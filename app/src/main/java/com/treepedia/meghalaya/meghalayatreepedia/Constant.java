package com.treepedia.meghalaya.meghalayatreepedia;

import java.sql.Array;

public final class Constant {

    private Constant() {
        // restrict instantiation
    }
    public static final int TREE_COUNT = 50;
    public static final int TREE_FIELDS_COUNT = 13;
    public static final String TEXT_FONT_COLOR = "#006400" ;
    public static final String TREE_FILE_NAME = "MeghalayaTreepedia.csv";
    public static final String[] TREE_FIELDS = {"ID No.", "Botanical Name", "Common Names", "General Information",	"Known Hazards",	"Range",	"Habitat",	"Properties",	"Cultivation Details",	"Edible Uses",	"Medicinal	Uses", "Other Uses",	"Propagation"} ;
}
