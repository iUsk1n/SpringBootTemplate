package com.market.sapphires.sbt.model.datatables.returned;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDataTables {

    private int draw;

    private int recordsTotal;

    private int recordsFiltered;

    private List<?> data = new ArrayList<>();

}
