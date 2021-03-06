package mcd.services;

import m.*;
import m.services.MRelEndService;
import mcd.*;
import mcd.interfaces.IMCDModel;
import messages.MessagesBuilder;
import org.apache.commons.lang.StringUtils;
import preferences.Preferences;
import project.ProjectService;
import utilities.window.scomponents.SComboBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MCDAssociationService {


    public static ArrayList<String> check(MCDAssociation mcdAssociation) {
        ArrayList<String> messages = new ArrayList<String>();
       return messages;
    }


    public static ArrayList<String> compliant(MCDAssociation mcdAssociation) {
        return check(mcdAssociation);
    }

    public static String buildNamingId(MCDEntity entityFrom, MCDEntity entityTo, String naming) {

        return  entityFrom.getNamePath(MCDElementService.PATHNAME) +
                Preferences.MCD_NAMING_ASSOCIATION_SEPARATOR +
                naming +
                Preferences.MCD_NAMING_ASSOCIATION_SEPARATOR +
                entityTo.getNamePath(MCDElementService.PATHNAME);

    }


    public static ArrayList<String> checkNature(SComboBox fieldNature,
                                                SComboBox fieldFromEntity,
                                                SComboBox fieldToEntity,
                                                SComboBox fieldFromMulti,
                                                SComboBox fieldToMulti) {

        ArrayList<String> messages = new ArrayList<String>();

        String multiFrom = (String) fieldFromMulti.getSelectedItem();
        String multiTo = (String) fieldToMulti.getSelectedItem();

        if (StringUtils.isNotEmpty(multiFrom)  && StringUtils.isNotEmpty(multiTo)) {
            MRelEndMultiPart multiMinFromStd = MRelEndService.computeMultiMinStd(multiFrom);
            MRelEndMultiPart multiMinToStd = MRelEndService.computeMultiMinStd(multiTo);
            MRelEndMultiPart multiMaxFromStd = MRelEndService.computeMultiMaxStd(multiFrom);
            MRelEndMultiPart multiMaxToStd = MRelEndService.computeMultiMaxStd(multiTo);
            MRelEndMulti multiFromStd = MRelEndService.computeMultiStd(multiFrom);
            MRelEndMulti multiToStd = MRelEndService.computeMultiStd(multiTo);

            MCDAssociationNature nature = MCDAssociationNature.findByText((String) fieldNature.getSelectedItem());

            if ((nature == MCDAssociationNature.IDCOMP) || (nature == MCDAssociationNature.CP)) {
                String contextMessage = "";
                if (nature == MCDAssociationNature.IDCOMP) {
                    contextMessage = MessagesBuilder.getMessagesProperty("mcd.association.nature.no.comp");
                }
                if (nature == MCDAssociationNature.CP) {
                    contextMessage = MessagesBuilder.getMessagesProperty("mcd.association.nature.sim.cp");
                }
                if ((fieldFromEntity !=null) && (fieldToEntity != null) &&
                        (fieldFromEntity.getSelectedIndex() == fieldToEntity.getSelectedIndex())){
                    messages.add(MessagesBuilder.getMessagesProperty("editor.association.nature.reflexive.error",
                            new String[]{contextMessage}));
                } else {
                    boolean c1a = multiFromStd == MRelEndMulti.MULTI_ONE_ONE;
                    boolean c1b = multiToStd == MRelEndMulti.MULTI_ONE_ONE;
                    boolean c2a = multiMaxToStd == MRelEndMultiPart.MULTI_MANY;
                    boolean c2b = multiMaxFromStd == MRelEndMultiPart.MULTI_MANY;

                    boolean ok = (c1a && c2a) || (c1b && c2b);
                    if (!ok) {
                        messages.add(MessagesBuilder.getMessagesProperty("editor.association.nature.id.pc.multi.error",
                                new String[]{contextMessage}));
                    }
                }
            }
            if (nature == MCDAssociationNature.IDNATURAL) {
                boolean c1a = (multiFromStd == MRelEndMulti.MULTI_ZERO_ONE) ||
                        (multiFromStd == MRelEndMulti.MULTI_ONE_ONE);
                boolean c1b = (multiToStd == MRelEndMulti.MULTI_ZERO_ONE) ||
                        (multiToStd == MRelEndMulti.MULTI_ONE_ONE);
                boolean c2a = multiMaxToStd == MRelEndMultiPart.MULTI_MANY;
                boolean c2b = multiMaxFromStd == MRelEndMultiPart.MULTI_MANY;
                boolean ok = (c1a && c2a) || (c1b && c2b);
                if (!ok) {
                    messages.add(MessagesBuilder.getMessagesProperty("editor.association.nature.idnat.multi.error"));
                }
            }
        }
        return messages;
    }


    public static ArrayList<String> checkOriented(SComboBox fieldOriented,
                                                  boolean recursif,
                                                  MRelationDegree degree) {

        ArrayList<String> messages = new ArrayList<String>();
        if (recursif){
            if (fieldOriented.isSelectedEmpty()){
                if (degree != MRelationDegree.DEGREE_ONE_MANY) {
                    messages.add(MessagesBuilder.getMessagesProperty("editor.association.nature.reflexive.oriented.error",
                            degree.getText()));
                }
            }
        } else {
            if (fieldOriented.isNotSelectedEmpty()) {
                messages.add(MessagesBuilder.getMessagesProperty("editor.association.nature.not.reflexive.oriented.error"));
            }

        }
        return messages;
    }

    public static ArrayList<MCDAssociation> getMCDAssociationsInIModel(IMCDModel iMCDModel) {
        ArrayList<MCDAssociation> resultat =  new ArrayList<MCDAssociation>();
        for (MCDElement element :  IMCDModelService.getMCDElementsByClassName(
                iMCDModel, false, MCDAssociation.class.getName())){
            resultat.add((MCDAssociation) element);
        }
        return resultat;
    }

    public static ArrayList<MCDAssociation> getMCDAssociationsNoIdInIModel(IMCDModel iMCDModel) {
        ArrayList<MCDAssociation> resultat =  new ArrayList<MCDAssociation>();
        for (MCDAssociation mcdAssociation :   getMCDAssociationsInIModel(iMCDModel)){
            if (mcdAssociation.getNature() == MCDAssociationNature.NOID) {
                resultat.add(mcdAssociation);
            }
        }
        return resultat;
    }


    public static void sortNameTreeAsc(ArrayList<MCDAssociation> associations){

        Collections.sort(associations, NAMETREE_ASC);
    }

    static final Comparator<MCDAssociation> NAMETREE_ASC =
            new Comparator<MCDAssociation>() {
                public int compare(MCDAssociation e1, MCDAssociation e2) {
                    return e1.getNameTree().compareTo(e2.getNameTree());
                }
            };



    public static MCDAssociation getMCDAssociationByNameTree(IMCDModel model, String nameTree){
        return (MCDAssociation) IMCDModelService.getMCDElementByClassAndNameTree(model, false,
                MCDAssociation.class.getName(), nameTree);
    }


    public static MCDAssociation getMCDAssociationByNameTree(String nameTree){
        for (MCDElement mcdElement : ProjectService.getMCDElementsByNameTree(nameTree)){
            if (mcdElement instanceof MCDAssociation){
                return (MCDAssociation) mcdElement;
            }
        }
        return null;
    }

}
