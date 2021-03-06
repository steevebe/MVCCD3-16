package preferences;


import main.MVCCDElement;

import java.awt.*;

public class Preferences extends MVCCDElement {

    private static final long serialVersionUID = 1000;

    public static String APPLICATION_NAME = "MVCCD";
    public static String LANGUAGE = "fr";
    public static String VERSION = "3.0.16";
    public static Integer JPANEL_HGAP = 5;
    public static Integer JPANEL_VGAP = 5;
    public static Integer PANEL_REPOSITORY_WIDTH = 200;
    public static String REPOSITORY_PROFILE_NAME = "Profile";
    public static String REPOSITORY_PREFERENCES_PROFILE_NAME = "Préférences de profil";
    public static String REPOSITORY_PREFERENCES_NAME = "Préférences de projet";  //Project
    public static String REPOSITORY_PREFERENCES_APPLICATION_NAME = "PréférencesApplication";  //Project
    public static String REPOSITORY_MCD_MODELS_NAME = "MCD";
    public static String REPOSITORY_MCD_PACKAGE_NAME = "Paquetage";
    public static String REPOSITORY_MCD_DIAGRAMS_NAME = "Diagrammes";
    public static String REPOSITORY_MCD_ENTITIES_NAME = "Entités";
    public static String REPOSITORY_MCD_RELATIONS_NAME = "Relations";
    public static String REPOSITORY_MCD_RELATIONS_ENDS_NAME = "Extrémités de relations";
    public static String REPOSITORY_MCD_ATTRIBUTES_NAME = "Attributs";
    public static String REPOSITORY_MCD_CONSTRAINTS_NAME = "Contraintes";
    public static Color BACKGROUND_PANEL = Color.LIGHT_GRAY;
    public static String REGEXPR_FIRSTCAR = "[a-zA-Z]{1,1}";
    public static String REGEXPR_NOFREE = "[a-zA-Z0-9_]*";
    public static String REGEXPR_FREE="([ ]{0,1}[a-zA-Z0-9_àâäçéèêëòöùûü]+)*";
    public static String NAME_REGEXPR = REGEXPR_FIRSTCAR + REGEXPR_NOFREE;
    public static String NAME_FREE_REGEXPR = REGEXPR_FIRSTCAR + REGEXPR_FREE ;
    public static String REGEXPR_1_99 ="[1-9]{1}[0-9]{0,1}";
    public static String MULTI_MERISE_N = "n";
    public static String MULTI_OCL_SP = "\\.\\.";
    public static String MULTI_CUSTOM_REGEXPR ="((0|" + REGEXPR_1_99 + ")" + MULTI_OCL_SP+ "("+ REGEXPR_1_99 + "|\\*|n))|1|\\*";
    public static Integer PROJECT_NAME_LENGTH = 50;
    public static Integer MODEL_NAME_LENGTH = 20;
    public static Integer MODEL_SHORT_NAME_LENGTH = 5;
    public static Integer MODEL_LONG_NAME_LENGTH = 50;
    public static Integer PACKAGE_NAME_LENGTH = 20;
    public static Integer PACKAGE_SHORT_NAME_LENGTH = 5;
    public static Integer PACKAGE_LONG_NAME_LENGTH = 50;
    public static Integer ENTITY_NAME_LENGTH = 20;
    public static Integer ENTITY_SHORT_NAME_LENGTH = 5;
    public static Integer ENTITY_LONG_NAME_LENGTH = 50;
    public static Integer ATTRIBUTE_NAME_LENGTH = 20;
    public static Integer ATTRIBUTE_SHORT_NAME_LENGTH = 10;
    public static Integer ATTRIBUTE_LONG_NAME_LENGTH = 50;
    public static Integer ASSOCIATION_NAME_LENGTH = 20;
    public static Integer ASSOCIATION_SHORT_NAME_LENGTH = 5;
    public static Integer ASSOCIATION_LONG_NAME_LENGTH = 50;
    public static Integer ASSEND_ROLE_NAME_LENGTH = 20;
    public static Integer ASSEND_ROLE_SHORT_NAME_LENGTH = 5;
    public static Integer UNIQUE_NAME_LENGTH = 20;
    public static Integer UNIQUE_SHORT_NAME_LENGTH = 5;
    public static Integer UNIQUE_LONG_NAME_LENGTH = 50;

    public static String INTEGER_REGEXPR = "([0])|([1-9]{1,1}[0-9]*)";
    //public static String XML_ENTETE_FICHIER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public static String XML_ENTETE_FICHIER = "<?xml version=\"1.0\" encoding=\"windows-1252\"?>";

    public static String XML_BALISE_PROJECT = "project";
    public static String XML_BALISE_DIAGRAMS = "diagrams";
    public static String XML_BALISE_ENTITIES = "entities";
    public static String XML_BALISE_ENTITY = "entity";
    public static String XML_BALISE_MODELS = "models";
    public static String XML_BALISE_PACKAGES = "packages";


    public static String XML_ATTRIBUTE_NAME = "name";
    public static String XML_ATTRIBUTE_SHORTNAME = "shortName";

    public static String FILE_PROJECT_EXTENSION = "mvccd";
    public static String FILE_PREFERENCES_EXTENSION = "pref";
    public static String FILE_PROFILE_EXTENSION = "profile";
    public static String FILE_DOT = ".";

    public static Integer FILES_RECENTS_MAX = 20;
    public static Integer FILES_RECENTS_AUTHORIZED = 20;
    public static String FILE_FILES_RECENTS_NAME = "recentFiles.dat";
    public static String FILE_APPLICATION_PREF_NAME = "application.pref";
    public static String FILE_HELP_PROJECT_NAME ="helpProject.txt";
    public static String FILE_HELP_PREFERENCES_NAME ="helpPreferences.txt";
    public static String FILE_HELP_MODEL_NAME = "helpModel.txt";
    public static String FILE_HELP_ENTITY_NAME = "helpEntity.txt";
    public static String FILE_HELP_ASSOCIATION_NAME = "helpAssociation.txt";
    public static String FILE_HELP_GENERALIZATION_NAME = "helpGeneralization.txt";
    public static String FILE_HELP_LINK_NAME = "helpLink.txt";
    public static String FILE_HELP_PARAMETER_NAME ="helpParameter.txt";

    public static String FILE_HELP_ANCHOR_NAME = "helpAnchor.txt";
    public static String FILE_HELP_MCDDATATYPE_NAME = "helpMCDDatatpe.txt";

    public static String DIRECTORY_PROFILE_NAME = "profiles";
    public static String DIRECTORY_RESSOURCES_NAME = "ressources";

    public static String SYSTEM_LINE_SEPARATOR =System.getProperty("line.separator");
    public static String SYSTEM_FILE_SEPARATOR =System.getProperty("file.separator");
    public static String CHARSET_FILES_TEXT = "UTF-8";

    public static String MODEL_NAME_PATH_SEPARATOR = ".";

    public static Integer PANEL_BUTTONS_MESSAGES_HEIGHT = 50;
    public static Integer MVCCD_WINDOW_WIDTH = 1200;
    public static Integer MVCCD_WINDOW_HEIGHT = 700;
    public static Integer PROJECT_WINDOW_WIDTH = 800;
    public static Integer PROJECT_WINDOW_HEIGHT = 400;
    public static Integer MODEL_WINDOW_WIDTH = 800;
    public static Integer MODEL_WINDOW_HEIGHT = 600;
    public static Integer ENTITY_WINDOW_WIDTH = 800;
    public static Integer ENTITY_WINDOW_HEIGHT = 600;
    public static Integer ATTRIBUTE_WINDOW_WIDTH = 800;
    public static Integer ATTRIBUTE_WINDOW_HEIGHT = 600;
    public static Integer ASSOCIATION_WINDOW_WIDTH = 1000;
    public static Integer ASSOCIATION_WINDOW_HEIGHT = 600;
    public static Integer UNIQUE_WINDOW_WIDTH = 1000;
    public static Integer UNIQUE_WINDOW_HEIGHT = 600;
    public static Integer PARAMETER_WINDOW_WIDTH = 400;
    public static Integer PARAMETER_WINDOW_HEIGHT = 300;
    public static Integer ANCHOR_WINDOW_WIDTH = 800;
    public static Integer ANCHOR_WINDOW_HEIGHT = 600;
    public static Integer GENSPEC_WINDOW_WIDTH = 800;
    public static Integer GENSPEC_WINDOW_HEIGHT = 600;
    public static Integer LINK_WINDOW_WIDTH = 800;
    public static Integer LINK_WINDOW_HEIGHT = 600;
    public static Integer HELP_WINDOW_WIDTH = 600;
    public static Integer HELP_WINDOW_HEIGHT = 300;
    public static Integer PREFERENCES_WINDOW_WIDTH = 1000;
    public static Integer PREFERENCES_WINDOW_HEIGHT = 600;
    public static Integer MCDDATATYPE_WINDOW_WIDTH = 800;
    public static Integer MCDDATATYPE_WINDOW_HEIGHT = 600;

    public static Integer EDITOR_FIELD_HEIGHT = 20;
    public static Integer EDITOR_TABLE_ROW_HEIGHT = 20;

    public static Color EDITOR_SCOMPONENT_BACKGROUND_NORMAL = Color.WHITE;
    public static Color EDITOR_SCOMPONENT_BACKGROUND_ERROR = Color.pink;
    public static Color EDITOR_SCOMPONENT_LINEBORDER_NORMAL = Color.gray;
    public static Color EDITOR_SCOMPONENT_LINEBORDER_ERROR = Color.RED;

    public static Color SCOMPONENT_INDIRECT_INPUT_FOREGROUND = Color.RED;

    public static String STEREOTYPE_SEPARATOR = "-";

    public static String STEREOTYPE_AID_NAME = "AID";
    public static String STEREOTYPE_AID_LIENPROG = "AID";
    public static String STEREOTYPE_M_NAME = "M";
    public static String STEREOTYPE_M_LIENPROG = "M";
    public static String STEREOTYPE_L_NAME = "L";
    public static String STEREOTYPE_L_LIENPROG = "L";
    public static String STEREOTYPE_LP_NAME = "LP";
    public static String STEREOTYPE_LP_LIENPROG = "LP";

    public static String STEREOTYPE_CID_NAME = "CID";
    public static String STEREOTYPE_CID_LIENPROG = "CID";

    public static int STEREOTYPE_NID_MAX = 5;
    public static String STEREOTYPE_NID_NAME = "NID";
    public static String STEREOTYPE_NID_LIENPROG = "NID";

    public static String STEREOTYPE_CP_NAME = "CP";
    public static String STEREOTYPE_CP_LIENPROG = "CP";

    public static int STEREOTYPE_U_MAX = 10;
    public static String STEREOTYPE_U_NAME = "U";
    public static String STEREOTYPE_U_LIENPROG = "U";

    public static String CONSTRAINT_ORDERED_NAME = "ordered";
    public static String CONSTRAINT_ORDERED_LIENPROG = "ordered";
    public static String CONSTRAINT_FROZEN_NAME = "frozen";
    public static String CONSTRAINT_FROZEN_LIENPROG = "frozen";
    public static String CONSTRAINT_DELETECASCADE_NAME = "deletecascade";
    public static String CONSTRAINT_DELETECASCADE_LIENPROG = "deletecascade";
    public static String CONSTRAINT_ORIENTED_NAME = "oriented";
    public static String CONSTRAINT_ORIENTED_LIENPROG = "oriented";
    public static String CONSTRAINT_NONORIENTED_NAME = "nonoriented";
    public static String CONSTRAINT_NONORIENTED_LIENPROG = "nonoriented";

    public static String CONSTRAINT_ABSOLUTE_NAME = "absolute";
    public static String CONSTRAINT_ABSOLUTE_LIENPROG = "absolute";

    public static String MCDDATATYPE_ROOT_NAME = "MCD";
    public static String MCDDATATYPE_ROOT_LIENPROG = "MCD";

    public static String MCDDATATYPE_BOOLEAN_NAME = "boolean";
    public static String MCDDATATYPE_BOOLEAN_LIENPROG = "boolean";

    public static String MCDDATATYPE_TEXT_NAME = "text";
    public static String MCDDATATYPE_TEXT_LIENPROG = "text";
    public static Integer MCDDATATYPE_TEXT_SIZEMIN = 1;
    public static String MCDDATATYPE_STRING_NAME = "string";
    public static String MCDDATATYPE_STRING_LIENPROG = "string";
    public static Integer MCDDATATYPE_STRING_SIZEMAX = 1000000000;
    public static Integer MCDDATATYPE_STRING_SIZEDEFAULT = 2000;
    public static String MCDDATATYPE_NORMALIZEDSTRING_NAME = "normalizedString";
    public static String MCDDATATYPE_NORMALIZEDSTRING_LIENPROG = "normalizedString";
    public static Integer MCDDATATYPE_NORMALIZEDSTRING_SIZEMAX = 100000;
    public static Integer MCDDATATYPE_NORMALIZEDSTRING_SIZEDEFAULT = 100;
    public static String MCDDATATYPE_TOKEN_NAME = "token";
    public static String MCDDATATYPE_TOKEN_LIENPROG = "token";
    public static Integer MCDDATATYPE_TOKEN_SIZEMAX = 10000;
    public static Integer MCDDATATYPE_TOKEN_SIZEDEFAULT = 50;
    public static String MCDDATATYPE_WORD_NAME = "word";
    public static String MCDDATATYPE_WORD_LIENPROG = "word";
    public static Integer MCDDATATYPE_WORD_SIZEMAX = 1000;
    public static Integer MCDDATATYPE_WORD_SIZEDEFAULT = 10;
    public static String MCDDATATYPE_EMAIL_NAME = "email";
    public static String MCDDATATYPE_EMAIL_LIENPROG = "email";
    public static Integer MCDDATATYPE_EMAIL_SIZEMIN = 5;
    public static Integer MCDDATATYPE_EMAIL_SIZEMAX = 200;
    public static Integer MCDDATATYPE_EMAIL_SIZEDEFAULT = 100;
    public static String MCDDATATYPE_HTTPURL_NAME = "httpURL";
    public static String MCDDATATYPE_HTTPURL_LIENPROG = "httpURL";
    public static Integer MCDDATATYPE_HTTPURL_SIZEMIN = 5;
    public static Integer MCDDATATYPE_HTTPURL_SIZEMAX = 2000;
    public static Integer MCDDATATYPE_HTTPURL_SIZEDEFAULT = 1000;
    public static String MCDDATATYPE_XML_NAME = "xml";
    public static String MCDDATATYPE_XML_LIENPROG = "xml";


    public static String MCDDATATYPE_NUMBER_NAME = "number";
    public static String MCDDATATYPE_NUMBER_LIENPROG = "number";
    public static Integer MCDDATATYPE_NUMBER_SIZEMIN = 1;

    public static String MCDDATATYPE_DECIMAL_NAME = "decimal";
    public static String MCDDATATYPE_DECIMAL_LIENPROG = "decimal";
    public static Integer MCDDATATYPE_DECIMAL_SIZEMAX = 30;
    public static Integer MCDDATATYPE_DECIMAL_SIZEDEFAULT = 10;
    public static Integer MCDDATATYPE_DECIMAL_SCALEMIN = 0;
    public static Integer MCDDATATYPE_DECIMAL_SCALEMAX = 10;
    public static Integer MCDDATATYPE_DECIMAL_SCALEDEFAULT = 2;
    public static String MCDDATATYPE_NONPOSITIVEDECIMAL_NAME = "nonPositiveDecimal";
    public static String MCDDATATYPE_NONPOSITIVEDECIMAL_LIENPROG = "nonPositiveDecimal";
    public static String MCDDATATYPE_NEGATIVEDECIMAL_NAME = "negativeDecimal";
    public static String MCDDATATYPE_NEGATIVEDECIMAL_LIENPROG = "negativeDecimal";
    public static String MCDDATATYPE_NONNEGATIVEDECIMAL_NAME = "nonNegativeDecimal";
    public static String MCDDATATYPE_NONNEGATIVEDECIMAL_LIENPROG = "nonNegativeDecimal";
    public static String MCDDATATYPE_POSITIVEDECIMAL_NAME = "postiveDecimal";
    public static String MCDDATATYPE_POSITIVEDECIMAL_LIENPROG = "positiveDecimal";

    public static String MCDDATATYPE_INTEGER_NAME = "integer";
    public static String MCDDATATYPE_INTEGER_LIENPROG = "integer";
    public static Integer MCDDATATYPE_INTEGER_SIZEMAX = 30;
    public static Integer MCDDATATYPE_INTEGER_SIZEDEFAULT = 8;
    public static String MCDDATATYPE_NONPOSITIVEINTEGER_NAME = "nonPositiveInteger";
    public static String MCDDATATYPE_NONPOSITIVEINTEGER_LIENPROG = "nonPositiveInteger";
    public static String MCDDATATYPE_NEGATIVEINTEGER_NAME = "negativeInteger";
    public static String MCDDATATYPE_NEGATIVEINTEGER_LIENPROG = "negativeInteger";
    public static String MCDDATATYPE_NONNEGATIVEINTEGER_NAME = "nonNegativeInteger";
    public static String MCDDATATYPE_NONNEGATIVEINTEGER_LIENPROG = "nonNegativeInteger";
    public static String MCDDATATYPE_POSITIVEINTEGER_NAME = "postiveInteger";
    public static String MCDDATATYPE_POSITIVEINTEGER_LIENPROG = "positiveInteger";

    public static String MCDDOMAIN_AID_NAME = "aid";
    public static String MCDDOMAIN_AID_LIENPROG = "aid";
    public static Integer MCDDOMAIN_AID_SIZEMIN = 9;
    public static Integer MCDDOMAIN_AID_SIZEMAX = 9;
    public static Integer MCDDOMAIN_AID_SIZEDEFAULT = 9;

    public static String MCDDATATYPE_MONEY_NAME = "money";
    public static String MCDDATATYPE_MONEY_LIENPROG = "money";
    public static Integer MCDDATATYPE_MONEY_SIZEMAX = 30;
    public static Integer MCDDATATYPE_MONEY_SIZEDEFAULT = 12;
    public static Integer MCDDATATYPE_MONEY_SCALEMIN = 0;
    public static Integer MCDDATATYPE_MONEY_SCALEMAX = 10;
    public static Integer MCDDATATYPE_MONEY_SCALEDEFAULT = 2;
    public static String MCDDATATYPE_NONPOSITIVEMONEY_NAME = "nonPositiveMoney";
    public static String MCDDATATYPE_NONPOSITIVEMONEY_LIENPROG = "nonPositiveMoney";
    public static String MCDDATATYPE_NEGATIVEMONEY_NAME = "negativeMoney";
    public static String MCDDATATYPE_NEGATIVEMONEY_LIENPROG = "negativeMoney";
    public static String MCDDATATYPE_NONNEGATIVEMONEY_NAME = "nonNegativeMoney";
    public static String MCDDATATYPE_NONNEGATIVEMONEY_LIENPROG = "nonNegativeMoney";
    public static String MCDDATATYPE_POSITIVEMONEY_NAME = "postiveMoney";
    public static String MCDDATATYPE_POSITIVEMONEY_LIENPROG = "positiveMoney";

    public static String MCDDATATYPE_TEMPORAL_NAME = "temporal";
    public static String MCDDATATYPE_TEMPORAL_LIENPROG = "temporal";

    public static String MCDDATATYPE_DURATION_NAME = "duration";
    public static String MCDDATATYPE_DURATION_LIENPROG = "duration";
    public static String MCDDATATYPE_DATETIME_NAME = "dateTime";
    public static String MCDDATATYPE_DATETIME_LIENPROG = "dateTime";
    public static String MCDDATATYPE_DATE_NAME = "date";
    public static String MCDDATATYPE_DATE_LIENPROG = "date";
    public static String MCDDATATYPE_TIME_NAME = "time";
    public static String MCDDATATYPE_TIME_LIENPROG = "time";
    public static String MCDDATATYPE_GYEARMONTH_NAME = "gYearMonth";
    public static String MCDDATATYPE_GYEARMONTH_LIENPROG = "gYearMonth";
    public static String MCDDATATYPE_GYEAR_NAME = "gYear";
    public static String MCDDATATYPE_GYEAR_LIENPROG = "gYear";
    public static String MCDDATATYPE_GMONTHDAY_NAME = "gMonthDay";
    public static String MCDDATATYPE_GMONTHDAY_LIENPROG = "gMonthDay";
    public static String MCDDATATYPE_GDAY_NAME = "gDay";
    public static String MCDDATATYPE_GDAY_LIENPROG = "gDay";
    public static String MCDDATATYPE_GMONTH_NAME = "gMonth";
    public static String MCDDATATYPE_GMONTH_LIENPROG = "gMonth";

    public static String MCDDATATYPE_NUMBER_SIZE_PRECISION = "mcddatatype.number.size.precision";
    public static String MCDDATATYPE_NUMBER_SIZE_INTEGER_PORTION_ONLY = "mcddatatype.number.size.integer.portion.only";


    public static String MCD_AID_IND_COLUMN_NAME_DEFAULT = "num";
    public static String MCD_AID_DEP_COLUMN_NAME_DEFAULT = "numDep";

    public static String MCD_NAMING_NAME="mcd.naming.name";
    public static String MCD_NAMING_SHORT_NAME="mcd.naming.short.name";

    public static String MCD_NAMING_ASSOCIATION_SEPARATOR = " ... ";
    public static String MCD_NAMING_ASSOCIATION_ARROW_RIGHT = " -> ";
    public static String MCD_NAMING_ASSOCIATION_ARROW_LEFT = " <- ";
    public static String MCD_NAMING_GENERALIZATION = " <|- ";
    public static String MCD_NAMING_LINK = " []--| ";

    public static String MCD_NAMING_GENERALIZATION_SPECIALIZE = " <|- ";
    public static String MCD_NAMING_GENERALIZATION_GENERALIZE = " -|> ";
    public static String MCD_NAMING_LINK_ELEMENT = " |--[] ";
    public static String MCD_NAMING_LINK_ASSOCIATION = " []--| ";

    public static String DIRECTORY_IMAGE_ICONE_RELATION = "images" + SYSTEM_FILE_SEPARATOR + "icones" + SYSTEM_FILE_SEPARATOR + "relations";
    public static String ICONE_RELATION_GENERALIZATION_LEFT_LG = "GeneralizationLeft.png";
    public static String ICONE_RELATION_GENERALIZATION_RIGHT_LG = "GeneralizationRight.png";
    public static String ICONE_RELATION_ASS_NONID_LG = "AssNonId.png";
    public static String ICONE_RELATION_ASS_ID_COMP_LEFT_LG = "AssIdCompLeft.png";
    public static String ICONE_RELATION_ASS_ID_COMP_RIGHT_LG = "AssIdCompRight.png";
    public static String ICONE_RELATION_ASS_ID_NAT_LEFT_LG = "AssIdNatLeft.png";
    public static String ICONE_RELATION_ASS_ID_NAT_RIGHT_LG = "AssIdNatRight.png";
    public static String ICONE_RELATION_LINK_LEFT_LG = "LinkLeft.png";
    public static String ICONE_RELATION_LINK_RIGHT_LG = "LinkRight.png";


    public static String GENERAL_RELATION_NOTATION_UML = "uml";
    public static String GENERAL_RELATION_NOTATION_STEREOTYPES = "stereotypes";

    public static String OPTION_ALWAYS = "option.always";
    public static String OPTION_NEVER = "option.never";
    public static String OPTION_YES = "option.yes";
    public static String OPTION_NO = "option.no";
    public static String OPTION_FREE = "option.free";

    public static String MCD_MODE_NAMING_SHORT_NAME = OPTION_YES;

    public static String MCD_ENTITY_NATURE_IND = "mcd.entity.nature.ind";
    public static String MCD_ENTITY_NATURE_DEP = "mcd.entity.nature.dep";
    public static String MCD_ENTITY_NATURE_ENTASS = "mcd.entity.nature.entass";
    public static String MCD_ENTITY_NATURE_ENTASSDEP = "mcd.entity.nature.entassdep";
    public static String MCD_ENTITY_NATURE_NAIRE = "mcd.entity.nature.naire";
    public static String MCD_ENTITY_NATURE_NAIREDEP = "mcd.entity.nature.nairedep";
    public static String MCD_ENTITY_NATURE_SPEC = "mcd.entity.nature.spec";
    public static String MCD_ENTITY_NATURE_PSEUDOENTASS = "mcd.entity.nature.pseudoentass";

    public static String MCD_ASSOCIATION_NATURE_NO_ID = "mcd.association.nature.no.id";
    public static String MCD_ASSOCIATION_NATURE_ID_NATURAL = "mcd.association.nature.no.natural";
    public static String MCD_ASSOCIATION_NATURE_ID_COMP = "mcd.association.nature.no.comp";
    public static String MCD_ASSOCIATION_NATURE_SIM_CP = "mcd.association.nature.sim.cp";

    public static String MCD_UNIQUE_NATURE_NO_ID = "mcd.unique.nature.no.id";
    public static String MCD_UNIQUE_NATURE_NID = "mcd.unique.nature.nid";

    public static String PREFERENCES_PROJECT_MENU_GENERAL = "preferences.project.menu.general";
    public static String PREFERENCES_PROJECT_MENU_MCD = "preferences.project.menu.mcd";

    // Modification Application
    private Boolean DEBUG = false;
    private Boolean DEBUG_BACKGROUND_PANEL = false;
    private Boolean DEBUG_PRINT_MVCCDELEMENT = false;
    private Boolean DEBUG_SHOW_TABLE_COL_HIDDEN = false;
    private Boolean DEBUG_INSPECT_OBJECT_IN_TREE = false;
    private Boolean DEBUG_EDITOR_DATAS_CHANGED = null;
    private Boolean REPOSITORY_MCD_MODELS_MANY = false;
    private Boolean REPOSITORY_MCD_PACKAGES_AUTHORIZEDS = false;


    //private PreferencesDisplay GENERAL_PREFERENCES_DISPLAY = PreferencesDisplay.REPOSITORY;

    // Modification User/Custom
    private String GENERAL_RELATION_NOTATION ;
    private Boolean MCD_JOURNALIZATION = false;
    private Boolean MCD_JOURNALIZATION_EXCEPTION = true;
    private Boolean MCD_AUDIT = false;
    private Boolean MCD_AUDIT_EXCEPTION = true;
    private String MCD_AID_DATATYPE_LIENPROG = null;
    private String MCDDATATYPE_NUMBER_SIZE_MODE = null;
    private String MCD_AID_IND_COLUMN_NAME = null;
    private String MCD_AID_DEP_COLUMN_NAME = null;
    private Boolean MCD_AID_WITH_DEP = true;
    private String MCD_TREE_NAMING_ASSOCIATION = null;
    private String MCD_MODE_NAMING_LONG_NAME = null;
    private String MCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME = null;

    private Dimension ENTITY_WINDOW_SIZE_CUSTOM = null;
    private Point ENTITY_WINDOW_LOCATION_ONSCREEN = null;
    private Dimension PREFERENCES_WINDOW_SIZE_CUSTOM = null;
    private Point PREFERENCES_WINDOW_LOCATION_ONSCREEN = null;




    public Preferences(MVCCDElement parent, String name) {
        super(parent, name);

    }

    // Application
    public Boolean isDEBUG() {
        return DEBUG;
    }

    public void setDEBUG(Boolean DEBUG) {
        this.DEBUG = DEBUG;
    }

    public Boolean isDEBUG_BACKGROUND_PANEL() {
        return DEBUG_BACKGROUND_PANEL;
    }

    public void setDEBUG_BACKGROUND_PANEL(Boolean DEBUG_BACKGROUND_PANEL) {
        this.DEBUG_BACKGROUND_PANEL = DEBUG_BACKGROUND_PANEL;
    }

    public Boolean isDEBUG_PRINT_MVCCDELEMENT() {
        return DEBUG_PRINT_MVCCDELEMENT;
    }
    

    public void setDEBUG_PRINT_MVCCDELEMENT(Boolean DEBUG_PRINT_MVCCDELEMENT) {
        this.DEBUG_PRINT_MVCCDELEMENT = DEBUG_PRINT_MVCCDELEMENT;
    }

    public Boolean isDEBUG_SHOW_TABLE_COL_HIDDEN() {
        return DEBUG_SHOW_TABLE_COL_HIDDEN;
    }

    public void setDEBUG_SHOW_TABLE_COL_HIDDEN(Boolean DEBUG_SHOW_TABLE_COL_HIDDEN) {
        this.DEBUG_SHOW_TABLE_COL_HIDDEN = DEBUG_SHOW_TABLE_COL_HIDDEN;
    }

    public Boolean getDEBUG_INSPECT_OBJECT_IN_TREE() {
        return DEBUG_INSPECT_OBJECT_IN_TREE;
    }

    public void setDEBUG_INSPECT_OBJECT_IN_TREE(Boolean DEBUG_INSPECT_OBJECT_IN_TREE) {
        this.DEBUG_INSPECT_OBJECT_IN_TREE = DEBUG_INSPECT_OBJECT_IN_TREE;
    }

    public Boolean getDEBUG_EDITOR_DATAS_CHANGED() {
        if (DEBUG_EDITOR_DATAS_CHANGED == null) {
            this.DEBUG_EDITOR_DATAS_CHANGED = false;
        }
        return DEBUG_EDITOR_DATAS_CHANGED;
    }

    public void setDEBUG_EDITOR_DATAS_CHANGED(Boolean DEBUG_EDITOR_DATAS_CHANGED) {
        this.DEBUG_EDITOR_DATAS_CHANGED = DEBUG_EDITOR_DATAS_CHANGED;
    }

    public Boolean getREPOSITORY_MCD_MODELS_MANY() {
        return REPOSITORY_MCD_MODELS_MANY;
    }

    public void setREPOSITORY_MCD_MODELS_MANY(Boolean REPOSITORY_MCD_MODELS_MANY) {
        this.REPOSITORY_MCD_MODELS_MANY = REPOSITORY_MCD_MODELS_MANY;
    }

    public Boolean getREPOSITORY_MCD_PACKAGES_AUTHORIZEDS() {
        return REPOSITORY_MCD_PACKAGES_AUTHORIZEDS;
    }

    public void setREPOSITORY_MCD_PACKAGES_AUTHORIZEDS(Boolean REPOSITORY_MCD_PACKAGES_AUTHORIZEDS) {
        this.REPOSITORY_MCD_PACKAGES_AUTHORIZEDS = REPOSITORY_MCD_PACKAGES_AUTHORIZEDS;
    }

    // Project

    public String getGENERAL_RELATION_NOTATION() {
        if (GENERAL_RELATION_NOTATION == null){
            GENERAL_RELATION_NOTATION = GENERAL_RELATION_NOTATION_UML;
        }
        return GENERAL_RELATION_NOTATION;
    }

    public void setGENERAL_RELATION_NOTATION(String GENERAL_RELATION_NOTATION) {
        this.GENERAL_RELATION_NOTATION = GENERAL_RELATION_NOTATION;
    }

    public Boolean getMCD_JOURNALIZATION() {
        return MCD_JOURNALIZATION;
    }
    public void setMCD_JOURNALIZATION(Boolean MCD_JOURNALIZATION) {
        this.MCD_JOURNALIZATION = MCD_JOURNALIZATION;
    }

    public Boolean getMCD_JOURNALIZATION_EXCEPTION() {
        return MCD_JOURNALIZATION_EXCEPTION;
    }

    public void setMCD_JOURNALIZATION_EXCEPTION(Boolean MCD_JOURNALIZATION_EXCEPTION) {
        this.MCD_JOURNALIZATION_EXCEPTION = MCD_JOURNALIZATION_EXCEPTION;
    }

    public Boolean getMCD_AUDIT() {
        return MCD_AUDIT;
    }
    public void setMCD_AUDIT(Boolean MCD_AUDIT) {
        this.MCD_AUDIT = MCD_AUDIT;
    }

    public Boolean getMCD_AUDIT_EXCEPTION() {
        return MCD_AUDIT_EXCEPTION;
    }

    public void setMCD_AUDIT_EXCEPTION(Boolean MCD_AUDIT_EXCEPTION) {
        this.MCD_AUDIT_EXCEPTION = MCD_AUDIT_EXCEPTION;
    }

    public String getMCD_AID_DATATYPE_LIENPROG() {
        if (MCD_AID_DATATYPE_LIENPROG == null){
            MCD_AID_DATATYPE_LIENPROG = MCDDOMAIN_AID_LIENPROG;
        }
        return MCD_AID_DATATYPE_LIENPROG;
    }

    public void setMCD_AID_DATATYPE_LIENPROG(String MCD_AID_DATATYPE_LIENPROG) {
        this.MCD_AID_DATATYPE_LIENPROG = MCD_AID_DATATYPE_LIENPROG;
    }

    public String getMCDDATATYPE_NUMBER_SIZE_MODE() {
        if (MCDDATATYPE_NUMBER_SIZE_MODE == null){
            MCDDATATYPE_NUMBER_SIZE_MODE = MCDDATATYPE_NUMBER_SIZE_PRECISION;
        }
        return MCDDATATYPE_NUMBER_SIZE_MODE;
    }

    public void setMCDDATATYPE_NUMBER_SIZE_MODE(String MCDDATATYPE_NUMBER_SIZE_MODE) {
        this.MCDDATATYPE_NUMBER_SIZE_MODE = MCDDATATYPE_NUMBER_SIZE_MODE;
    }

    public String getMCD_AID_IND_COLUMN_NAME() {
        if (MCD_AID_IND_COLUMN_NAME == null){
            MCD_AID_IND_COLUMN_NAME = MCD_AID_IND_COLUMN_NAME_DEFAULT;
        }
        return MCD_AID_IND_COLUMN_NAME;
    }

    public void setMCD_AID_IND_COLUMN_NAME(String MCD_AID_IND_COLUMN_NAME) {
        this.MCD_AID_IND_COLUMN_NAME = MCD_AID_IND_COLUMN_NAME;
    }

    public String getMCD_AID_DEP_COLUMN_NAME() {
        if (MCD_AID_DEP_COLUMN_NAME == null){
            MCD_AID_DEP_COLUMN_NAME = MCD_AID_DEP_COLUMN_NAME_DEFAULT;
        }return MCD_AID_DEP_COLUMN_NAME;
    }

    public void setMCD_AID_DEP_COLUMN_NAME(String MCD_AID_DEP_COLUMN_NAME) {
        this.MCD_AID_DEP_COLUMN_NAME = MCD_AID_DEP_COLUMN_NAME;
    }

    public Boolean isMCD_AID_WITH_DEP() {
        return MCD_AID_WITH_DEP;
    }

    public void setMCD_AID_WITH_DEP(Boolean MCD_AID_WITH_DEP) {
        this.MCD_AID_WITH_DEP = MCD_AID_WITH_DEP;
    }


    public String getMCD_TREE_NAMING_ASSOCIATION() {
        if(MCD_TREE_NAMING_ASSOCIATION  == null){
            MCD_TREE_NAMING_ASSOCIATION = MCD_NAMING_NAME;
        }
        return MCD_TREE_NAMING_ASSOCIATION;
    }

    public void setMCD_TREE_NAMING_ASSOCIATION(String MCD_TREE_NAMING_ASSOCIATION) {
        this.MCD_TREE_NAMING_ASSOCIATION = MCD_TREE_NAMING_ASSOCIATION;
    }

    public String getMCD_MODE_NAMING_LONG_NAME() {
        if (MCD_MODE_NAMING_LONG_NAME == null){
            MCD_MODE_NAMING_LONG_NAME = OPTION_NO;
        }
        return MCD_MODE_NAMING_LONG_NAME;
    }

    public void setMCD_MODE_NAMING_LONG_NAME(String MCD_MODE_NAMING_LONG_NAME) {
        this.MCD_MODE_NAMING_LONG_NAME = MCD_MODE_NAMING_LONG_NAME;
    }

    public String getMCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME() {
        if (MCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME == null){
            MCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME = OPTION_NO;
        }return MCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME;
    }

    public void setMCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME(String MCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME) {
        this.MCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME = MCD_MODE_NAMING_ATTRIBUTE_SHORT_NAME;
    }

    public Dimension getENTITY_WINDOW_SIZE_CUSTOM() {
        if (ENTITY_WINDOW_SIZE_CUSTOM == null){
            ENTITY_WINDOW_SIZE_CUSTOM = new Dimension( ENTITY_WINDOW_WIDTH, ENTITY_WINDOW_HEIGHT );
        }
        return ENTITY_WINDOW_SIZE_CUSTOM;
    }

    public void setENTITY_WINDOW_SIZE_CUSTOM(Dimension ENTITY_WINDOW_SIZE_CUSTOM) {
        this.ENTITY_WINDOW_SIZE_CUSTOM = ENTITY_WINDOW_SIZE_CUSTOM;
    }

    public Point getENTITY_WINDOW_LOCATION_ONSCREEN() { 
        return ENTITY_WINDOW_LOCATION_ONSCREEN;
    }

    public void setENTITY_WINDOW_LOCATION_ONSCREEN(Point ENTITY_WINDOW_LOCATION_ONSCREEN) {
        this.ENTITY_WINDOW_LOCATION_ONSCREEN = ENTITY_WINDOW_LOCATION_ONSCREEN;
    }

    public Dimension getPREFERENCES_WINDOW_SIZE_CUSTOM() {
        if (PREFERENCES_WINDOW_SIZE_CUSTOM == null){
            PREFERENCES_WINDOW_SIZE_CUSTOM = new Dimension( PREFERENCES_WINDOW_WIDTH, PREFERENCES_WINDOW_HEIGHT );
        }
        return PREFERENCES_WINDOW_SIZE_CUSTOM;
    }

    public void setPREFERENCES_WINDOW_SIZE_CUSTOM(Dimension PREFERENCES_WINDOW_SIZE_CUSTOM) {
        this.PREFERENCES_WINDOW_SIZE_CUSTOM = PREFERENCES_WINDOW_SIZE_CUSTOM;
    }

    public Point getPREFERENCES_WINDOW_LOCATION_ONSCREEN() {
        return PREFERENCES_WINDOW_LOCATION_ONSCREEN;
    }

    public void setPREFERENCES_WINDOW_LOCATION_ONSCREEN(Point PREFERENCES_WINDOW_LOCATION_ONSCREEN) {
        this.PREFERENCES_WINDOW_LOCATION_ONSCREEN = PREFERENCES_WINDOW_LOCATION_ONSCREEN;
    }
}
