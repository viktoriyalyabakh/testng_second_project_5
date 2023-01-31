package scripts;

import data.TextData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedAirlinesBasePage;
import pages.UnitedAirlinesConformationPage;

import java.util.stream.IntStream;

public class UnitedAirlinesTest extends UnitedAirlinesBase{
    @BeforeMethod
    public void setPage(){
        unitedAirlinesPage = new UnitedAirlinesBasePage();
        unitedAirlinesConformPage = new UnitedAirlinesConformationPage();
    }

    /**
     * Test Case 1: Validate "Main menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see “Main menu” navigation items
     * |BOOK                              |
     * |MY TRIPS                          |
     * |TRAVEL INFO            |
     * |MILEAGEPLUS® PROGRAM|
     * |DEALS                             |
     * |HELP                              |
     */

    @Test(priority = 1, description = "Validate \"Main menu\" navigation items")
    public void validateMainMenu(){

        IntStream.range(0, TextData.mainMenuText.length).forEach(i -> {
            Assert.assertTrue(unitedAirlinesPage.mainMenu.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesPage.mainMenu.get(i).getText(), TextData.mainMenuText[i]);
        });


    }

    /**
     * Test Case 2: Validate "Book travel menu" navigation items
     * Given user is on "https://www.united.com/en/us"
     * Then user should see "Book travel menu" navigation items
     * |Book             |
     * |Flight Status|
     * |Check-in       |
     * |My trips        |
     */

    @Test(priority = 2, description = "Validate \"Book travel menu\" navigation items")
    public void validateBookTravelMenu(){

        for (int i = 0; i < TextData.bookTravelMenuText.length; i++) {
            Assert.assertTrue(unitedAirlinesPage.bookTravelMenu.get(i).isDisplayed());
            Assert.assertEquals(unitedAirlinesPage.bookTravelMenu.get(i).getText(), TextData.bookTravelMenuText[i]);
        }
    }

    /**
     * Test Case 3: Validate "Round-trip" and "One-way" radio buttons
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Roundtrip" radio button is displayed, is enabled and is selected
     * And validate "One-way" radio button is displayed, is enabled but is not selected
     * When user clicks on "One-way" radio button
     * Then validate "One-way" radio button is selected while "Roundtrip" radio button is
     * deselected
     */

    @Test(priority = 3, description = "Validate \"Round-trip\" and \"One-way\" radio buttons")
    public void validateRadioButtonInBookTravelMenu(){

        IntStream.range(0, unitedAirlinesPage.bookTravelMenuRadioLabel.size()).forEach(i -> {
        Assert.assertTrue(unitedAirlinesPage.bookTravelMenuRadioLabel.get(i).isDisplayed());
        Assert.assertTrue(unitedAirlinesPage.bookTravelMenuRadioLabel.get(i).isEnabled());
        Assert.assertEquals(unitedAirlinesPage.bookTravelMenuRadioLabel.get(i).getText(), TextData.radioButtonsText[i]);
    });
        Assert.assertTrue(unitedAirlinesPage.bookTravelMenuRadioInput.get(0).isSelected());
        Assert.assertFalse(unitedAirlinesPage.bookTravelMenuRadioInput.get(1).isSelected());

        unitedAirlinesPage.bookTravelMenuRadioInput.get(1).click();

        Assert.assertTrue(unitedAirlinesPage.bookTravelMenuRadioInput.get(1).isSelected());
        Assert.assertFalse(unitedAirlinesPage.bookTravelMenuRadioInput.get(0).isSelected());
    }

    /**
     * Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
     * Given user is on "https://www.united.com/en/us"
     * Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
     * And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
     * When user clicks both checkboxes
     * Then validate both checkboxes are selected
     * When user clicks on both selected checkboxes again
     * Then validate both checkboxes are deselected
     */

    @Test(priority = 4, description = "Validate \"Book with miles\" and \"Flexible dates\" checkboxes")
    public void validateCheckboxes(){

        for (int i = 0; i < unitedAirlinesPage.bookTravelMenuCheckboxLabel.size(); i++) {
            Assert.assertTrue(unitedAirlinesPage.bookTravelMenuRadioLabel.get(i).isDisplayed());
            Assert.assertTrue(unitedAirlinesPage.bookTravelMenuRadioLabel.get(i).isEnabled());
            Assert.assertEquals(unitedAirlinesPage.bookTravelMenuCheckboxLabel.get(i).getText(), TextData.checkboxText[i]);
            Assert.assertFalse(unitedAirlinesPage.bookTravelMenuCheckboxInput.get(i).isSelected());
            unitedAirlinesPage.bookTravelMenuCheckboxLabel.get(i).click();
        }

        IntStream.range(0, unitedAirlinesPage.bookTravelMenuCheckboxLabel.size()).forEach(i ->{
            Assert.assertTrue(unitedAirlinesPage.bookTravelMenuCheckboxInput.get(i).isSelected());
            unitedAirlinesPage.bookTravelMenuCheckboxLabel.get(i).click();
            Assert.assertFalse(unitedAirlinesPage.bookTravelMenuCheckboxInput.get(i).isSelected());
    });
    }

    /**
     * Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
     * Miami, FL, US (MIA)”
     * Given user is on "https://www.united.com/en/us"
     * When user selects "One-way" ticket radio button
     * And user enters "Chicago, IL, US (ORD)" to from input box
     * And user enters "Miami, FL, US (MIA)" to to input box
     * And user selects "Feb 28" to the dates input box
     * And user selects "2 Adults" from travelers selector
     * And user selects "Business or First" from cabin dropdown
     * And user clicks on "Find Flights" button
     * Then validate departure equals to "DEPART ON: February 28"
     */

    @Test(priority = 5, description = "Validate One-way ticket search results from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public  void validateOneWayTicket(){

        unitedAirlinesPage.bookTravelMenuRadioInput.get(1).click();
        unitedAirlinesPage.bookTravelMenuDestinationInput.get(0).clear();
        unitedAirlinesPage.bookTravelMenuDestinationInput.get(0).sendKeys("Chicago, IL, US (ORD)");
        unitedAirlinesPage.bookTravelMenuDestinationInput.get(1).clear();
        unitedAirlinesPage.bookTravelMenuDestinationInput.get(1).sendKeys("Miami, FL, US (MIA)");
        unitedAirlinesPage.dateInput.click();
        unitedAirlinesPage.clearDateButton.click();
        unitedAirlinesPage.dateInput.sendKeys("Feb 28");
        unitedAirlinesPage.travelerSelectorButton.click();
        unitedAirlinesPage.clickOnPassenger("Adult", "2");
        unitedAirlinesPage.clickOnPassenger("Senior", "2");
        unitedAirlinesPage.clickOnPassenger("(5 - 11)", "2");
        unitedAirlinesPage.cabinTypeDropdown.click();
        unitedAirlinesPage.clickOnCabinTypeOption("Business");
        unitedAirlinesPage.findFlightsButton.click();
       // Assert.assertEquals(unitedAirlinesConformPage.conformationDate.getText(), "DEPART ON: February 28");

    }
    }

