package org.example.spring_hw001.repository;

import org.apache.ibatis.annotations.*;
import org.example.spring_hw001.model.entity.Person;
import org.example.spring_hw001.model.request.PersonRequest;

import java.util.List;

@Mapper
public interface PersonRepo {

    @Select("SELECT * FROM persons")
    @Results(id = "PersonMapper", value = {
            @Result(property = "id",     column = "id"),
            @Result(property = "name",   column = "name"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "age",    column = "age")
    })
    List<Person> findAllPersons();

    @Insert("INSERT INTO persons(name, gender, age) VALUES(#{name}, #{gender}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createPerson(Person person);

    @Select("SELECT * FROM persons WHERE id = #{id}")
    @ResultMap("PersonMapper")
    Person findById(long id);

    @Select("SELECT * FROM persons WHERE name = #{name}")
    @ResultMap("PersonMapper")
    List<Person> findByName(String name);

    @Update("""
        UPDATE persons
        SET name   = #{req.name},
            gender = #{req.gender},
            age    = #{req.age}
        WHERE id = #{id}
    """)
    int updateById(@Param("id") long id, @Param("req") PersonRequest personRequest);

    @Delete("DELETE FROM persons WHERE id = #{id}")
    void deleteById(long id);
}