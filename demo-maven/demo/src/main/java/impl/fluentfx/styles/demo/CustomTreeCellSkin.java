package impl.fluentfx.styles.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.skin.TreeCellSkin;

public class CustomTreeCellSkin<T> extends TreeCellSkin<T> {
    public CustomTreeCellSkin(TreeCell control) {
        super(control);
    }

    private boolean disclosureNodeDirty = true;


    @Override
    protected void layoutChildren(double x, double y, double w, double h) {
        try {

            TreeView<T> tree = getSkinnable().getTreeView();
            if (tree == null) return;

            if (disclosureNodeDirty) {
                Method method =TreeCellSkin.class.getDeclaredMethod("updateDisclosureNode");
                method.setAccessible(true);
                method.invoke(this);
                disclosureNodeDirty=false;
            }

            Node disclosureNode = getSkinnable().getDisclosureNode();

            TreeItem<?> treeItem = getSkinnable().getTreeItem();

            int level = tree.getTreeItemLevel(treeItem);
            if (!tree.isShowRoot()) level--;
            double leftMargin = getIndent() * level;

            x += leftMargin;

            // position the disclosure node so that it is at the proper indent
            boolean disclosureVisible = disclosureNode != null && treeItem != null && !treeItem.isLeaf();
            Field field = TreeCellSkin.class.getDeclaredField("maxDisclosureWidthMap");
            field.setAccessible(true);
            Map<TreeView<?>, Double> maxDisclosureWidthMap = (Map<TreeView<?>, Double>) field.get(this);
            final double defaultDisclosureWidth =  0;   // RT-19656: default width of default disclosure node
            double disclosureWidth = defaultDisclosureWidth;

            if (disclosureVisible) {
                if (disclosureNode == null || disclosureNode.getScene() == null) {
                    updateChildren();
                }
         if (disclosureNode != null) {
                    disclosureWidth = disclosureNode.prefWidth(h);
                    if (disclosureWidth > defaultDisclosureWidth) {
                        maxDisclosureWidthMap.put(tree, disclosureWidth);
                    }

                    double ph = disclosureNode.prefHeight(disclosureWidth);

                    disclosureNode.resize(disclosureWidth, ph);
                    positionInArea(disclosureNode, x, y,
                            disclosureWidth, ph, /*baseline ignored*/0,
                            HPos.CENTER, VPos.CENTER);
                }
            }

            // determine starting point of the graphic or cell node, and the
            // remaining width available to them
            final int padding = treeItem != null && treeItem.getGraphic() == null ? 0 : 3;
            x += disclosureWidth + padding;
            w -= (leftMargin + disclosureWidth + padding);

            // Rather ugly fix for RT-38519, where graphics are disappearing in
            // certain circumstances
            Node graphic = getSkinnable().getGraphic();
            if (graphic != null && !getChildren().contains(graphic)) {
                getChildren().add(graphic);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        layoutLabelInArea(x, y, w, h);
    }


}