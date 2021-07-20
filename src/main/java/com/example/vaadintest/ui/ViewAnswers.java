package com.example.vaadintest.ui;

import com.example.vaadintest.backend.entity.Company;
import com.example.vaadintest.backend.entity.Contact;
import com.example.vaadintest.backend.service.CompanyService;
import com.example.vaadintest.backend.service.ContactService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;

@Route("/dhuiq8djanahqufnajkn/ewdhhuwhduiqnjk/admin/answers/0")
public class ViewAnswers extends HorizontalLayout {
    private Grid<Contact> grid = new Grid<>(Contact.class);
    private ContactService contactService;
    private signUp form;

    public ViewAnswers(ContactService contactService){
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        this.contactService = contactService;
        updateList();

        form = new signUp();

        Div content = new Div(grid, form);
        content.setSizeFull();
        add(content);

    }

    private void configureGrid(){
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("company");
        grid.setColumns("firstName", "lastName", "email", "status");
        grid.addColumn(contact -> {
            Company company = contact.getCompany();
            return company == null ? "-" : company.getName();
        }).setHeader("Company");
        grid.addComponentColumn(item -> createRemoveButton(grid, item))
                .setHeader("Actions");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }


    private Button createRemoveButton(Grid<Contact> grid, Contact item) {
        @SuppressWarnings("unchecked")
        Button button = new Button("Remove", clickEvent -> {
            ListDataProvider<Contact> dataProvider = (ListDataProvider<Contact>) grid
                    .getDataProvider();
            contactService.delete(item);
            item.setFirstName("Joe");
            contactService.save(item);
          //  dataProvider.getItems().remove(item);
           // dataProvider.refreshAll();
            updateList();
        });
        return button;
    }



    private void updateList(){
        grid.setItems(contactService.findAll());
    }
}
