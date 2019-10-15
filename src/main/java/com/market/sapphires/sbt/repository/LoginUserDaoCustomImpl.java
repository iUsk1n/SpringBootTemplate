package com.market.sapphires.sbt.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.market.sapphires.sbt.entity.LoginUser;
import com.market.sapphires.sbt.model.datatables.returned.UserDataTables;

public class LoginUserDaoCustomImpl implements LoginUserDaoCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<LoginUser> find4DataTables(
            int start,
            int length,
            List<List<Object>> search,
            List<List<Object>> order) {

        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<LoginUser> query = cb.createQuery(LoginUser.class);
        Root<LoginUser> root = query.from(LoginUser.class);

        List<Predicate> where = new ArrayList<>();
        search.stream().forEach(s -> {
            if (StringUtils.isEmpty(s.get(1))) {
                return;
            }

            UserDataTables.Column column = (UserDataTables.Column) s.get(0);
            switch (column) {
            case USERNAME:
                // fall through
            case FULLNAME:
                // fall through
            case COMMENT:
                where.add(cb.like(
                        root.get(column.getName()),
                        new StringBuilder("%").append(s.get(1)).append("%").toString()));
                break;
            case ENABLED:
                if (Boolean.parseBoolean((String) s.get(1))) {
                    where.add(cb.isTrue(root.get(column.getName())));
                } else {
                    where.add(cb.isFalse(root.get(column.getName())));
                }
                break;
            case GROUPS:
                // TODO
                break;
            case UPDATED_DATE:
                // none
                break;
            default:
                // do nothing
            }
        });

        List<Order> orderBy = order.stream().map(o -> {
            if ("desc".equalsIgnoreCase((String) o.get(1))) {
                return cb.desc(root.get(((UserDataTables.Column) o.get(0)).getName()));
            } else {
                return cb.asc(root.get(((UserDataTables.Column) o.get(0)).getName()));
            }
        }).collect(Collectors.toList());

        query
                .select(root)
                .where(cb.and(where.toArray(new Predicate[] {})))
                .orderBy(orderBy);

        return this.entityManager.createQuery(query)
                .setFirstResult(start)
                .setMaxResults(length)
                .getResultList();
    }

}
