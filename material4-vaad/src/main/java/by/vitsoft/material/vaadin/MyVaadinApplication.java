/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package by.vitsoft.material.vaadin;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import by.vitsoft.material.dto.Unit;
import by.vitsoft.material.service.GuideService;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Configurable(preConstruction = true)
public class MyVaadinApplication extends Application {

    @Autowired
    private GuideService guideService;

    private Window window;

    @Override
    public void init()
    {
        window = new Window("My Vaadin Application");
        setMainWindow(window);
        //window.addComponent(new Button("Click Me"));

        // Create a table. It is by default not editable.
        final Table table = new Table();
        // Define the names and data types of columns.
        //table.addContainerProperty("Date", Date.class, null);
        //table.addContainerProperty("Work", Boolean.class, null);
        table.addContainerProperty("Id", Long.class, null);
        table.addContainerProperty("UnitId", Long.class, null);
        table.setColumnHeader("UnitId", "Код");
        table.addContainerProperty("UnitName", String.class, null);
        table.setColumnHeader("UnitName", "Имя");
        // Add a few items in the table.
        List<Unit> units =  guideService.getUnits();
        for (Unit unit: units ) {
            table.addItem(new Object[] {unit.getId(), unit.getUnitId(), unit.getUnitName()},
                    unit.getId()); // Item identifier
        }
        table.setPageLength(10);
        window.addComponent(table);

        final CheckBox switchEditable = new CheckBox("Editable");
        switchEditable.addListener(new Property.ValueChangeListener() {
        public void valueChange(ValueChangeEvent event) {
        table.setEditable(((Boolean)event.getProperty()
        .getValue()).booleanValue());
        }
        });
        switchEditable.setImmediate(true);
        window.addComponent(switchEditable);
    }
}
