/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package at.rbi.login.client.application;

import java.util.List;

import org.eclipse.jetty.server.Authentication.User;

import com.google.gwt.cell.client.ButtonCellBase.DefaultAppearance.Style;
import com.google.gwt.dom.client.Document;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.base.error.ErrorHandler;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.ui.*;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    MaterialContainer container;

//    @UiField
//    MaterialButton btnAdd;

    @UiField
    MaterialTextBox loginName;
    
    @UiField
    MaterialTextBox loginPassword;
    
    @UiField
    MaterialButton loginButton;
    
    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        
        loginPassword.setType(InputType.PASSWORD);

        Document.get().getElementById("splashscreen").removeFromParent();
    }

    @UiHandler("loginButton")
    void onAdd(ClickEvent e) {
    	if (loginName.getText().isEmpty()) {
    		loginName.setErrorText("User name is mandatory");
    	} else {
    		loginName.clearErrorText();
    		MaterialToast.fireToast("I love GMD");
    	}
    }
}
