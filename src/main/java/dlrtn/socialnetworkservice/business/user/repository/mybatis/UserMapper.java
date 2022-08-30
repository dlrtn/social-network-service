package dlrtn.socialnetworkservice.business.user.repository.mybatis;

import dlrtn.socialnetworkservice.business.user.model.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("INSERT INTO USER(username, password, email, user_type, created_at, updated_at) VALUES(#{username}, #{password}, #{email}, #{user_type}, #{created_at}, #{updated_at}")
    int save(@Param("User") final User user);

    @Select("SELECT * FROM USER WHERE username = #{username}")
    int existsByUsername(@Param("User") final User user);

}
