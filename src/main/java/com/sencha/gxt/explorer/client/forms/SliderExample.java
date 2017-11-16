package com.sencha.gxt.explorer.client.forms;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.explorer.client.app.ui.ExampleContainer;
import com.sencha.gxt.explorer.client.model.Example.Detail;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

@Detail(
    name = "Slider",
    category = "Forms",
    icon = "slider",
    preferredHeight = SliderExample.PREFERRED_HEIGHT,
    preferredWidth = SliderExample.PREFERRED_WIDTH
)
public class SliderExample implements IsWidget, EntryPoint {

  protected static final int PREFERRED_HEIGHT = -1;
  protected static final int PREFERRED_WIDTH = 220;

  private ContentPanel panel;

  @Override
  public Widget asWidget() {
    if (panel == null) {
      final Slider slider1 = new Slider();

      final Slider slider2 = new Slider(true);
      slider2.setIncrement(1);

      TextButton button1 = new TextButton("Set value to 40");
      button1.addSelectHandler(new SelectHandler() {
        @Override
        public void onSelect(SelectEvent event) {
          slider1.setValue(40);
        }
      });

      TextButton button2 = new TextButton("Set value to 20");
      button2.addSelectHandler(new SelectHandler() {
        @Override
        public void onSelect(SelectEvent event) {
          slider2.setValue(20);
        }
      });

      VerticalPanel vpanel = new VerticalPanel();
      vpanel.setSpacing(10);
      vpanel.add(slider1);
      vpanel.add(button1);
      vpanel.add(slider2);
      vpanel.add(button2);

      panel = new ContentPanel();
      panel.setHeading("Slider");
      panel.add(vpanel);
    }

    return panel;
  }

  @Override
  public void onModuleLoad() {
    new ExampleContainer(this)
        .setPreferredHeight(PREFERRED_HEIGHT)
        .setPreferredWidth(PREFERRED_WIDTH)
        .doStandalone();
  }

}