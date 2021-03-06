package main.window.repository;

import datatypes.MCDDatatype;
import diagram.mcd.MCDDiagram;
import m.IMCompletness;
import main.MVCCDElement;
import main.MVCCDElementApplicationPreferences;
import main.MVCCDManager;
import main.MVCCDWindow;
import mcd.*;
import messages.MessagesBuilder;
import repository.editingTreat.diagram.MCDDiagramEditingTreat;
import repository.editingTreat.mcd.*;
import repository.editingTreat.preferences.PrefApplEditingTreat;
import repository.editingTreat.preferences.PrefGeneralEditingTreat;
import repository.editingTreat.preferences.PrefMCDEditingTreat;
import preferences.Preferences;
import preferences.PreferencesManager;
import profile.Profile;
import project.Project;
import repository.editingTreat.*;
import utilities.window.scomponents.ISMenu;
import utilities.window.scomponents.SMenu;
import utilities.window.scomponents.SPopupMenu;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WinRepositoryPopupMenu extends SPopupMenu {
    private DefaultMutableTreeNode node;
    private DefaultTreeModel treeModel;
    private MVCCDWindow mvccdWindow;
    private MVCCDElement mvccdElement;

    public WinRepositoryPopupMenu(DefaultMutableTreeNode node) {
        this.treeModel = treeModel;
        this.node = node;
        mvccdWindow = MVCCDManager.instance().getMvccdWindow();
        mvccdElement = (MVCCDElement) node.getUserObject();
        init();
    }

    private void init() {

        if (PreferencesManager.instance().getApplicationPref().isDEBUG()) {
            if (PreferencesManager.instance().getApplicationPref().getDEBUG_INSPECT_OBJECT_IN_TREE()) {
                treatInspectObject();
            }
        }
        if (node.getUserObject() instanceof MVCCDElementApplicationPreferences) {
            treatGenericUpdate(this, new PrefApplEditingTreat());
        }

        if (node.getUserObject() instanceof MCDDatatype) {
            treatGenericRead(this, new MCDDatatypeEditingTreat());
        }

        if (node.getUserObject() instanceof Preferences) {
            treatPreferences(this);
        }

        if (node.getUserObject() instanceof Profile) {
            treatProfile(this);
        }

        if (node.getUserObject() instanceof Project) {
            treatProject(this);
        }

        if (node.getUserObject() instanceof MCDContModels) {
            treatModels(this);
        }

        if (node.getUserObject() instanceof MCDModel) {
            treatGeneric(this, new MCDModelEditingTreat());
            treatGenericCompliant(this, new MCDModelEditingTreat());
            packageNew(this, true);
        }

        if (node.getUserObject() instanceof MCDPackage) {
            treatGeneric(this, new MCDPackageEditingTreat());
            treatGenericCompliant(this, new MCDPackageEditingTreat());
            packageNew(this, false);
        }

        if (node.getUserObject() instanceof MCDContDiagrams) {
            treatGenericNew(this, new MCDDiagramEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.new.diagram"));
        }
        if (node.getUserObject() instanceof MCDDiagram) {
            treatGeneric(this, new MCDDiagramEditingTreat());
        }

        if (node.getUserObject() instanceof MCDContEntities) {
            treatGenericNew( this, new MCDEntityEditingTreat());
        }

        if (node.getUserObject() instanceof MCDEntity) {
            treatGeneric(this, new MCDEntityEditingTreat());
            //treatGenericCompliant(this, new MCDEntityEditingTreat());
            treatGenericRead(this, new MCDEntCompliantEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.compliant"));
        }

        if (node.getUserObject() instanceof MCDContAttributes) {
            treatGenericNew( this, new MCDAttributeEditingTreat());
            treatGenericRead( this, new MCDAttributesEditingTreat());
        }

        if (node.getUserObject() instanceof MCDContConstraints) {
            treatConstraints( this);
        }

        if (node.getUserObject() instanceof MCDAttribute) {
            treatGeneric(this, new MCDAttributeEditingTreat());
        }

        if (node.getUserObject() instanceof MCDContRelEnds) {
            treatGenericRead( this, new MCDRelEndsEditingTreat());
        }

        if (node.getUserObject() instanceof MCDContRelations) {
            treatRelations(this);
        }

        if ( (node.getUserObject() instanceof MCDUnique) &&
                (!(node.getUserObject() instanceof MCDNID))){
            treatGenericNew( this, new MCDUniqueParameterEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.new.operation.parameter"));
            treatGeneric(this, new MCDUniqueEditingTreat());
        }

        if (node.getUserObject() instanceof MCDNID) {
            treatGenericNew( this, new MCDNIDParameterEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.new.operation.parameter"));
            treatGeneric(this, new MCDNIDEditingTreat());
        }

        if (node.getUserObject() instanceof MCDAssociation) {
            treatGeneric(this, new MCDAssociationEditingTreat());
        }

        if (node.getUserObject() instanceof MCDAssEnd) {
            mvccdElement = ((MCDAssEnd) node.getUserObject()).getMcdAssociation();
            treatGeneric(this, new MCDAssociationEditingTreat());
        }

        if (node.getUserObject() instanceof MCDGeneralization) {
            treatGeneric(this, new MCDGeneralizationEditingTreat());
        }

        if (node.getUserObject() instanceof MCDGSEnd) {
            mvccdElement = ((MCDGSEnd) node.getUserObject()).getMcdGeneralization();
            treatGeneric(this, new MCDGeneralizationEditingTreat());
        }

        if (node.getUserObject() instanceof MCDLink) {
            treatGeneric(this, new MCDLinkEditingTreat());
        }

        if (node.getUserObject() instanceof MCDLinkEnd) {
            mvccdElement = ((MCDLinkEnd) node.getUserObject()).getMcdLink();
            treatGeneric(this, new MCDLinkEditingTreat());
        }

    }



    private void treatInspectObject() {
        JMenuItem inspecter = new JMenuItem("Inpecter l'objet --> Résultat dans la console!");
        this.add(inspecter);
        inspecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(node.getUserObject().getClass().getName());
            }
        });

    }

    private void treatProfile(ISMenu menu) {
    }

    private void treatPreferences(ISMenu menu) {

        SMenu preferencesEdit = new SMenu(MessagesBuilder.getMessagesProperty("menu.preferences"));
        addItem(menu, preferencesEdit);
        DefaultMutableTreeNode nodeParent = (DefaultMutableTreeNode) node.getParent();

        if (nodeParent.getUserObject() instanceof Profile) {
            treatGenericRead( preferencesEdit, new PrefGeneralEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.preferences.general"));

            treatGenericRead( preferencesEdit, new PrefMCDEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.preferences.mcd"));
        }
        if (nodeParent.getUserObject() instanceof Project) {
            treatGenericUpdate( preferencesEdit, new PrefGeneralEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.preferences.general"));

            treatGenericUpdate( preferencesEdit, new PrefMCDEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.preferences.mcd"));

            JMenuItem preferencesExportProfil = new JMenuItem(MessagesBuilder.getMessagesProperty("menu.export.profil.preferences"));
            addItem(menu, preferencesExportProfil);
            preferencesExportProfil.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    PreferencesManager.instance().createProfile();
                }
            });

        }
    }


    private void treatProject(ISMenu menu) {
        JMenuItem editProject = new JMenuItem(MessagesBuilder.getMessagesProperty("menu.update"));
        addItem(menu, editProject);
        editProject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Pas d'extension de la classe EditingTreat
                ProjectEditingTreat.treatUpdate(mvccdWindow);
            }
        });
    }

    private void treatModels(ISMenu menu) {
        if (PreferencesManager.instance().preferences().getREPOSITORY_MCD_MODELS_MANY()) {
            treatGenericNew( menu, new MCDModelEditingTreat(),
                    MessagesBuilder.getMessagesProperty("menu.new.model"));
       } else {
            packageNew(menu, true);
            treatGenericCompliant(menu, new MCDContModelsEditingTreat());
        }
    }


    private void treatRelations(ISMenu menu) {
        treatGenericNew(this, new MCDAssociationEditingTreat(),
                MessagesBuilder.getMessagesProperty("menu.new.association"));
        treatGenericNew(this, new MCDGeneralizationEditingTreat(),
                MessagesBuilder.getMessagesProperty("menu.new.generalization"));
        treatGenericNew(this, new MCDLinkEditingTreat(),
                MessagesBuilder.getMessagesProperty("menu.new.link"));
        treatGenericDeleteChilds(this, new MCDRelationsEditingTreat());
    }

    private void treatConstraints(ISMenu menu) {
        treatGenericNew(this, new MCDNIDEditingTreat(),
                MessagesBuilder.getMessagesProperty("menu.new.constraint.nid"));
        treatGenericNew(this, new MCDUniqueEditingTreat(),
                MessagesBuilder.getMessagesProperty("menu.new.constraint.unique"));
        treatGenericRead( this, new MCDConstraintsEditingTreat());

    }

    private void packageNew(ISMenu menu, boolean top) {
        if (PreferencesManager.instance().preferences().getREPOSITORY_MCD_PACKAGES_AUTHORIZEDS()) {
            String propertyMessage ;
            if (top) {
                propertyMessage = "menu.new.package";
            } else {
                propertyMessage = "menu.new.subpackage";
            }
            treatGenericNew( menu, new MCDPackageEditingTreat(),
                    MessagesBuilder.getMessagesProperty(propertyMessage));
         }
    }


    private void treatGeneric(ISMenu menu, EditingTreat editingTreat) {
        treatGenericRead(menu, editingTreat);
        treatGenericUpdate(menu, editingTreat);
        treatGenericDelete(menu, editingTreat);

        if (mvccdElement instanceof IMCompletness) {
            treatGenericCompletness(menu, editingTreat);
        }
    }

    private void treatGenericNew(ISMenu menu, EditingTreat editingTreat) {
        String textMenu = MessagesBuilder.getMessagesProperty("menu.new");
        treatGenericNew(menu, editingTreat, textMenu);
    }

    private void treatGenericNew(ISMenu menu, EditingTreat editingTreat, String textMenu) {
        JMenuItem menuItem = new JMenuItem(textMenu);
        addItem(menu, menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editingTreat.treatNew(mvccdWindow, mvccdElement);
            }
        });
    }


    private void treatGenericRead(ISMenu menu, EditingTreat editingTreat) {
        String textMenu = MessagesBuilder.getMessagesProperty("menu.read");
        treatGenericRead(menu, editingTreat, textMenu);
    }

    private void treatGenericRead(ISMenu menu, EditingTreat editingTreat, String textMenu) {
        JMenuItem menuItem = new JMenuItem(textMenu);
        addItem(menu, menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                editingTreat.treatRead(mvccdWindow, mvccdElement);
            }
        });
    }

    private void treatGenericUpdate(ISMenu menu, EditingTreat editingTreat) {
        String textMenu = MessagesBuilder.getMessagesProperty("menu.update");
        treatGenericUpdate(menu, editingTreat, textMenu);
    }

    private void treatGenericUpdate(ISMenu menu, EditingTreat editingTreat, String textMenu) {
        JMenuItem menuItem = new JMenuItem(textMenu);
        addItem(menu, menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editingTreat.treatUpdate(mvccdWindow, mvccdElement);
            }
        });
    }

    private void treatGenericDelete(ISMenu menu, EditingTreat editingTreat) {
        String textMenu = MessagesBuilder.getMessagesProperty("menu.delete");
        treatGenericDelete(menu, editingTreat, textMenu);
    }

    private void treatGenericDelete(ISMenu menu, EditingTreat editingTreat, String textMenu) {
        JMenuItem menuItem = new JMenuItem(textMenu);
        addItem(menu, menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editingTreat.treatDelete(mvccdWindow, mvccdElement);
            }
        });
    }

    private void treatGenericDeleteChilds(ISMenu menu, EditingTreat editingTreat) {
        String textMenu = MessagesBuilder.getMessagesProperty("menu.delete.childs");
        treatGenericDeleteChilds(menu, editingTreat, textMenu);
    }

    private void treatGenericDeleteChilds(ISMenu menu, EditingTreat editingTreat, String textMenu) {
        JMenuItem menuItem = new JMenuItem(textMenu);
        addItem(menu, menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editingTreat.treatDeleteChilds(mvccdWindow, mvccdElement);
            }
        });
    }

    private void treatGenericCompletness(ISMenu menu, EditingTreat editingTreat) {
        JMenuItem menuItem = new JMenuItem(MessagesBuilder.getMessagesProperty("menu.completness"));
        addItem(menu, menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editingTreat.treatCompletness(mvccdWindow, mvccdElement, true);
            }
        });
    }

    private void treatGenericCompliant(ISMenu menu, EditingTreat editingTreat) {
        JMenuItem menuItem = new JMenuItem(MessagesBuilder.getMessagesProperty("menu.compliant"));
        addItem(menu, menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<String> messages = editingTreat.treatCompliant(mvccdWindow, mvccdElement);
            }
        });
    }

    private void addItem(ISMenu menu, JMenuItem menuItem) {
        if (menu instanceof SPopupMenu) {
            ((SPopupMenu) menu).add(menuItem);
        }
        if (menu instanceof SMenu) {
            ((SMenu) menu).add(menuItem);
        }
    }
}
