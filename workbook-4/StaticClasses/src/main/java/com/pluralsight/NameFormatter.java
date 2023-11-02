package com.pluralsight;

public class NameFormatter {

    public static String format(String firstName, String lastName){
        //Name must not contain non-alphabet characters
        if(!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")){
            System.out.println("ERROR: NAME MUST ONLY CONTAIN LETTERS!");
            return "ERROR";
        }
        //Name needs to have input for each part
        else if(firstName.isBlank() || lastName.isBlank()){
            System.out.println("ERROR: NAME MUST NOT HAVE ANY BLANK PARTS!");
            return "ERROR";
        }

        else { //Valid input
            //Ensure proper casing
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

            return String.format("%s, %s", lastName, firstName);
        }
    }

    public static String format(String prefix, String firstName, String lastName, String middleName, String suffix){
        //Name must not contain non-alphabet characters (Prefix can have period, Middle/Last can have comma)
        if(!prefix.matches("[a-zA-Z.]+") || !firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z,]+") || !middleName.matches("[a-zA-Z,]+") || !suffix.matches("[a-zA-Z]+")){
            System.out.println("ERROR: NAME MUST ONLY CONTAIN LETTERS!");
            return "ERROR";
        }
        //Name needs to have input for each part
        else if(prefix.isBlank() || firstName.isBlank() || lastName.isBlank() || middleName.isBlank() || suffix.isBlank()){
            System.out.println("ERROR: NAME MUST NOT HAVE ANY BLANK PARTS!");
            return "ERROR";
        }
        else { //Valid input
            if(prefix.charAt(prefix.length()-1) != '.'){ //Check prefix for ending period
                prefix += ".";
            }
            if(middleName.charAt(middleName.length()-1) != ','){ //Check middleName for ending comma
                middleName += ",";
            }
            if(lastName.charAt(lastName.length()-1) != ','){ //Check lastName for ending comma
                lastName += ",";
            }
            //Ensure prefix starts with capital
            prefix = prefix.substring(0, 1).toUpperCase() + prefix.substring(1);
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
            middleName = middleName.substring(0, 1).toUpperCase() + middleName.substring(1).toLowerCase();
            //Ensure suffix starts with capital
            suffix = suffix.substring(0, 1).toUpperCase() + suffix.substring(1);
            return String.format("%s %s %s %s %s", lastName, prefix, firstName, middleName, suffix);
        }
    }

    public static String format(String fullName){
        //Name must not contain non-alphabet characters except for period, comma, or space
        if(!fullName.matches("[a-zA-Z., ]+")){
            System.out.println("ERROR: NAME MUST ONLY CONTAIN LETTERS!");
            return "ERROR";
        }
        //Name needs to be an actual input
        else if(fullName.isBlank()){
            System.out.println("ERROR: NAME MUST NOT BE BLANK!");
            return "ERROR";
        }
        else { //Valid input
            String output = "";
            String[] parts = fullName.split("\\s"); //Split name on whitespace char
            switch (parts.length) {
                case 2 -> { //Input = First Last
                    //Give name proper casing
                    parts[0] = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();
                    parts[1] = parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1).toLowerCase();
                    //Output = "Last, First"
                    output = String.format("%s, %s", parts[1], parts[0]);
                }

                case 4 -> { //Input = First Middle Last, Suffix
                    if(parts[2].charAt(parts[2].length()-1) != ','){ //Check last name for ending comma
                        parts[2] += ",";
                    }
                    if(parts[1].charAt(parts[1].length()-1) != ','){ //Check middle name for ending comma
                        parts[1] += ",";
                    }

                    //Give name proper casing
                    parts[0] = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();
                    parts[1] = parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1).toLowerCase();
                    parts[2] = parts[2].substring(0, 1).toUpperCase() + parts[2].substring(1).toLowerCase();
                    //Ensure suffix starts with capital
                    parts[3] = parts[3].substring(0, 1).toUpperCase() + parts[3].substring(1);
                    //Output = "Last, First Middle, Suffix"
                    output = String.format("%s %s %s %s", parts[2], parts[0], parts[1], parts[3]);
                }

                case 5 -> { //Input = Prefix. First Middle Last, Suffix
                    if(parts[0].charAt(parts[0].length()-1) != '.'){ //Check prefix for ending period
                        parts[0] += ".";
                    }
                    if(parts[3].charAt(parts[3].length()-1) != ','){ //Check last name for ending comma
                        parts[3] += ",";
                    }
                    if(parts[2].charAt(parts[2].length()-1) != ','){ //Check middle name for ending comma
                        parts[2] += ",";
                    }

                    //Give name proper casing
                    //Ensure Prefix starts with capital
                    parts[0] = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
                    parts[1] = parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1).toLowerCase();
                    parts[2] = parts[2].substring(0, 1).toUpperCase() + parts[2].substring(1).toLowerCase();
                    parts[3] = parts[3].substring(0, 1).toUpperCase() + parts[3].substring(1).toLowerCase();
                    //Ensure suffix starts with capital
                    parts[4] = parts[4].substring(0, 1).toUpperCase() + parts[4].substring(1);
                    //Output = "Last, Prefix. First Middle, Suffix"
                    output = String.format("%s %s %s %s %s", parts[3], parts[0], parts[1], parts[2], parts[4]);
                }

                default -> {
                    System.out.println("ERROR: INVALID NAME FORMAT");
                    output = "ERROR";
                }
            }
            return output;
        }
    }

    public static void main(String[] args) {
        System.out.println(format(""));
    }
}
