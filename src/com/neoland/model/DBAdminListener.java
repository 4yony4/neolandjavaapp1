package com.neoland.model;

import com.neoland.dataclass.User;
import com.neoland.infraestructure.Property;

import java.util.HashMap;

public interface DBAdminListener {

    public double dGravity=9.8;

    public void conexionSuccess(boolean blSuccess);
    public void dbResponseUsers(HashMap<String, User> mapUsers);
    public void dbResponseProperyElement(Property property);


}
