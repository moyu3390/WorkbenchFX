package com.dlsc.workbenchfx.view.controls;

import com.dlsc.workbenchfx.Workbench;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Represents a toolbar, which displays all toolbar items of a
 * {@link com.dlsc.workbenchfx.model.WorkbenchModule}.
 * It consists of two areas to display the items: The left and the right toolbarControlBox.
 *
 * @author François Martin
 * @author Marco Sanfratello
 */
public class ToolbarControl extends HBox {

  private HBox toolbarControlLeftBox;
  private HBox toolbarControlRightBox;

  /**
   * Creates an empty {@link ToolbarControl} object and fully initializes it.
   */
  public ToolbarControl() {
    initializeParts();
    layoutParts();
  }

  private void initializeParts() {
    getStylesheets().add(
        Workbench.class.getResource("css/toolbar-control.css").toExternalForm()
    );

    getStyleClass().add("toolbar-control");

    toolbarControlLeftBox = new HBox();
    toolbarControlLeftBox.getStyleClass().add("toolbar-control-left-box");

    toolbarControlRightBox = new HBox();
    toolbarControlRightBox.getStyleClass().add("toolbar-control-right-box");

    ObservableSet<Node> objects = FXCollections.observableSet();
    toolbarControlLeftBox.getChildren().setAll(objects);
  }

  private void layoutParts() {
    getChildren().addAll(
        toolbarControlLeftBox,
        toolbarControlRightBox
    );
    HBox.setHgrow(toolbarControlLeftBox, Priority.ALWAYS);
  }

  public void addToolbarControlLeft(Node toolbarControl) {
    toolbarControlLeftBox.getChildren().add(toolbarControl);
  }

  public void removeToolbarControlLeft(Node toolbarControl) {
    toolbarControlLeftBox.getChildren().remove(toolbarControl);
  }

  public void addToolbarControlRight(Node toolbarControl) {
    toolbarControlRightBox.getChildren().add(toolbarControl);
  }

  public void removeToolbarControlRight(Node toolbarControl) {
    toolbarControlRightBox.getChildren().remove(toolbarControl);
  }

  /**
   * Returns whether the {@link ToolbarControl} is empty or not.
   * @return whether the {@link ToolbarControl} is empty or not
   */
  public boolean isEmpty() {
    return toolbarControlLeftBox.getChildren().isEmpty()
        && toolbarControlRightBox.getChildren().isEmpty();
  }

  /**
   * Clears the {@link ToolbarControl}'s items
   */
  public void clear() {
    toolbarControlLeftBox.getChildren().clear();
    toolbarControlRightBox.getChildren().clear();
  }
}
