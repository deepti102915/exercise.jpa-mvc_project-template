package com.github.perscholas.dto;

import com.github.perscholas.model.Person;
import com.github.perscholas.model.PersonBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */ // TODO - Implement DtoInterface<Person>
public class PersonDto implements DtoInterface<Person> {
    private final ResultSet resultSet;

    public PersonDto(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public ResultSet getResultSet() {
        return resultSet;
    }

    @Override
    public List<Person> toList() {
        try {
            List<Person> result = new ArrayList<>();
            while(getResultSet().next()) {
                result.add(new PersonBuilder()
                        .setId(getResultSet().getLong("id"))
                        .setEmail(getResultSet().getString("email"))
                        .setName(getResultSet().getString("name"))
                        .setPassword(getResultSet().getString("password"))
                        .build());
            }
            return result;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
