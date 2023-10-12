package org.example.app.controller;

import org.example.app.entity.Product;
import org.example.app.service.ProductService;
import org.example.app.utils.Constants;
import org.example.app.utils.AppStarter;
import org.example.app.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("productController")
public class ProductControllerImpl implements BaseController {

    @Autowired
    ProductMenuView menuView;
    @Autowired
    ProductCreateView createView;
    @Autowired
    ProductReadView readView;
    @Autowired
    ProductReadByIdView readByIdView;
    @Autowired
    ProductUpdateView updateView;
    @Autowired
    ProductDeleteView deleteView;
    @Autowired
    ProductService serviceImpl;

    public ProductControllerImpl() {
    }

    public void getOption() {
        int option = Integer.parseInt(menuView.getOption());
        switch (option) {
            case 1 -> create();
            case 2 -> getAll();
            case 3 -> getById();
            case 4 -> update();
            case 5 -> delete();
            case 0 -> menuView.getOutput(Constants.APP_CLOSE_MSG);
        }
    }

    public void create() {
        Product product = createView.getData();
        createView.getOutput(serviceImpl.create(product));
        AppStarter.startApp();
    }

    public void getAll() {
        readView.getOutput(serviceImpl.getAll());
        AppStarter.startApp();
    }

    public void getById() {
        readByIdView.getOutput(serviceImpl
                .getById(readByIdView.getData()));
        AppStarter.startApp();
    }

    public void update() {
        Map<String, String> data = updateView.getData();
        int id = Integer.parseInt(data.get("id"));
        String name = data.get("name");
        int quota = Integer.parseInt(data.get("quota"));
        double price = readDouble(data.get("price"));

        Product product = new Product(id, name, quota, price);
        updateView.getOutput(serviceImpl.update(product));
        AppStarter.startApp();
    }

    private double readDouble(String input) {
        input = input.replace(',', '.');
        return Double.parseDouble(input);
    }

    public void delete() {
        deleteView.getOutput(serviceImpl
                .delete(deleteView.getData()));
        AppStarter.startApp();
    }
}
