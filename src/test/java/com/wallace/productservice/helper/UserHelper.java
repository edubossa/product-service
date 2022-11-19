package com.wallace.productservice.helper;
import com.wallace.productservice.model.CityModel;

import com.wallace.productservice.model.UserModel;

import java.util.Optional;

public class UserHelper {
    public static Optional<UserModel> get() {
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        userModel.setCpf("");
        userModel.setName("");
        userModel.setAddress("");
        userModel.setCity(new CityModel());
        return Optional.of(userModel);
    }
}
