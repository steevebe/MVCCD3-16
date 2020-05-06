package utilities.window.scomponents.services;

import org.apache.commons.lang.StringUtils;
import utilities.window.scomponents.SComboBox;
import utilities.window.scomponents.STextField;

public class SComboBoxService {

    public static void selectByText(SComboBox sComboBox, String text) {
        for (int i=0 ; i <  sComboBox.getItemCount(); i++){
            if ( sComboBox.getItemAt(i).equals(text)){
                sComboBox.setSelectedIndex(i);
            }
        }
    }


    public static <ComboBoxAdapter> void selectByTextEditable(SComboBox sComboBox, String text) {
        if (StringUtils.isNotEmpty(text)) {
            boolean find = false;
            for (int i = 0; i < sComboBox.getItemCount(); i++) {
                if (sComboBox.getItemAt(i).equals(text)) {
                    find = true;
                    sComboBox.setSelectedIndex(i);
                }
            }
            if (!find) {
                sComboBox.removeItemAt(0);
                sComboBox.insertItemAt(text, 0);
                sComboBox.setSelectedIndex(0);
            }
        }
    }



}

