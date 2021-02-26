package ru.psu.dao;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.psu.generated.tables.daos.AppUserDao;

@Repository
public class AppUserDaoImpl extends AppUserDao {

    private final DSLContext jooq;

    public AppUserDaoImpl(DSLContext jooq) {
        super(jooq.configuration());
        this.jooq = jooq;
    }
}
