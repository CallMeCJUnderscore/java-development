package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class NameFormatterTest {

    @Test
    public void If_FormatFirstLastGivenNumbers_Then_SendNumError() {
        /*-------------ARRANGE-------------*/
        String firstName = "j0sh";
        String lastName = "w3inst31n";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(firstName, lastName);

        /*-------------ASSERT--------------*/
        assertEquals(output, "ERROR");
    }

    @Test
    public void If_FormatFirstLastGivenBlank_Then_SendBlankError() {
        /*-------------ARRANGE-------------*/
        String firstName = "josh";
        String lastName = "";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(firstName, lastName);

        /*-------------ASSERT--------------*/
        assertEquals(output, "ERROR");
    }

    @Test
    public void If_FormatFirstLastGivenOnlyLetters_Then_ReturnsNameWithProperCasing() {
        /*-------------ARRANGE-------------*/
        String firstName = "joshua";
        String lastName = "weINstein";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(firstName, lastName);

        /*-------------ASSERT--------------*/
        assertEquals(output, "Weinstein, Joshua");
    }

    @Test
    public void If_FormatAllPartsGivenNumber_Then_SendNumError() {
        /*-------------ARRANGE-------------*/
        String prefix = "1";
        String firstName = "FIRST";
        String middleName = "middle";
        String lastName = "LAST";
        String suffix = "suffix";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(prefix, firstName, middleName, lastName, suffix);

        /*-------------ASSERT--------------*/
        assertEquals(output, "ERROR");
    }

    @Test
    public void If_FormatAllPartsGivenBlank_Then_SendBlankError() {
        /*-------------ARRANGE-------------*/
        String prefix = "";
        String firstName = "FIRST";
        String middleName = "middle";
        String lastName = "LAST";
        String suffix = "suffix";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(prefix, firstName, middleName, lastName, suffix);

        /*-------------ASSERT--------------*/
        assertEquals(output, "ERROR");
    }

    @Test
    public void If_FormatAllPartsGivenOnlyLetters_Then_SendNameWithProperCasing() {
        /*-------------ARRANGE-------------*/
        String prefix = "Prefix";
        String firstName = "FIRST";
        String middleName = "middle";
        String lastName = "LAST";
        String suffix = "suffix";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(prefix, firstName, lastName, middleName, suffix);

        /*-------------ASSERT--------------*/
        assertEquals(output, "Last, Prefix. First Middle, Suffix");
    }

    @Test
    public void If_FormatOnePartGivenBlank_Then_SendBlankError() {
        /*-------------ARRANGE-------------*/
        String name = "   ";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(name);

        /*-------------ASSERT--------------*/
        assertEquals(output, "ERROR");
    }

    @Test
    public void If_FormatOnePartGivenNumber_Then_SendNumberError() {
        /*-------------ARRANGE-------------*/
        String name = "1";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(name);

        /*-------------ASSERT--------------*/
        assertEquals(output, "ERROR");
    }

    @Test
    public void If_FormatOnePartGivenWrongSize_Then_SendSizeError() {
        /*-------------ARRANGE-------------*/
        String name = "Joshua";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(name);

        /*-------------ASSERT--------------*/
        assertEquals(output, "ERROR");
    }

    @Test
    public void If_FormatOnePartGivenTwoWords_Then_ReturnLastFirstCase() {
        /*-------------ARRANGE-------------*/
        String name = "fIRST Last";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(name);

        /*-------------ASSERT--------------*/
        assertEquals(output, "Last, First");
    }

    @Test
    public void If_FormatOnePartGivenFourWords_Then_ReturnFirstMiddleLastSuffixCase() {
        /*-------------ARRANGE-------------*/
        String name = "first middle last suffix";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(name);

        /*-------------ASSERT--------------*/
        assertEquals(output, "Last, First Middle, Suffix");
    }

    @Test
    public void If_FormatOnePartGivenFiveWords_Then_ReturnLastPrefixFirstMiddleSuffixCase() {
        /*-------------ARRANGE-------------*/
        String name = "prefix FIRST Middle last, Suffix";

        /*---------------ACT---------------*/
        String output = NameFormatter.format(name);

        /*-------------ASSERT--------------*/
        assertEquals(output, "Last, Prefix. First Middle, Suffix");
    }
}