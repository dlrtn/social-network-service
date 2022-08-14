package dlrtn.socialnetworkservice.business.user.repository.implementation;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;

import static com.dlrtn.websocket.chat.business.chat.model.domain.generated.study_db.Tables.USER;

@RequiredArgsConstructor
public class UserJooqRepository {

    private final DSLContext dslContext;

    public void save(User user) {
        dslContext.insertInto(USER,
                        USER.USERNAME,
                        USER.PASSWORD,
                        USER.EMAIL,
                        USER.USER_TYPE,
                        USER.CREATED_AT,
                        USER.UPDATED_AT)
                .values(user.getUsername(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getUserType(),
                        user.getCreatedAt(), //todo jooq converter java: localdatetime to sql: date 만들어야함
                        user.getUpdatedAt())
                .execute();
    }

    public User findByUsername(String username) {
        return dslContext.select()
                .from(USER)
                .where(USER.USERNAME.eq(username))
                .fetchOneInto(User.class); //todo optional로 받을 수 있나?
    }

    public void update(User user) {
        dslContext.update(USER)
                .set(USER.PASSWORD, user.getPassword())
                .set(USER.UPDATED_AT, user.getUpdatedAt())
                .where(USER.USERNAME.eq(user.getUsername()))
                .execute();
    }

    public void delete(String username) {
        dslContext.delete(USER)
                .where(USER.USERNAME.eq(username))
                .execute();
    }

    public Boolean existsByUsername(String username) { //limit이 exists와 성능이 비슷하므로.. 사용
        dslContext.select()
                .from(USER)
                .where(USER.USERNAME.eq(username))
                .limit(1)
                .execute();
    }

}
