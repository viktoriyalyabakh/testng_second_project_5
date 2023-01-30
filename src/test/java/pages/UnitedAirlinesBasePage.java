package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedAirlinesBasePage {

    public UnitedAirlinesBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[role='tablist'] a")
    public List<WebElement> mainMenu;

    @FindBy(css = "ul[class*='-BookTravel-'] li")
    public List<WebElement> bookTravelMenu;

    @FindBy(css = "fieldset[name='flightType'] input")
    public List<WebElement> bookTravelMenuRadioInput;

    @FindBy(css = "fieldset[name='flightType'] label")
    public List<WebElement> bookTravelMenuRadioLabel;

    @FindBy(css = "div[class*='checkboxWrapper'] input")
    public List<WebElement> bookTravelMenuCheckboxInput;

    @FindBy(css = "div[class*='checkboxWrapper'] label")
    public List<WebElement> bookTravelMenuCheckboxLabel;

    @FindBy(css = "div[class*='autocompleteInputContainer--2B_Ng'] input")
    public List<WebElement> bookTravelMenuDestinationInput;

    @FindBy(id = "DepartDate")
    public WebElement dateInput;

    @FindBy(css = "button[aria-label='Clear Dates']")
    public WebElement clearDateButton;

    @FindBy(css = "#passengerSelector button")
    public WebElement travelerSelectorButton;

    @FindBy(css = "#passengerMenuId input")
    public List<WebElement> travelerSelectorInput;

    @FindBy(css = "#passengerMenuId span")
    public List<WebElement> travelerSelectorLabel;


    @FindBy(id = "cabinType")
    public WebElement cabinTypeDropdown;

    @FindBy(css = "li[id^='cabinType_item-']")
    public List<WebElement> cabinTypeOptions;

    @FindBy(css = "button[class*='findFlightBtn']")
    public WebElement findFlightsButton;


    public void clickOnPassenger(String passenger, String numberOfPassenger){
        for (int i = 0; i < travelerSelectorInput.size(); i++) {
            if(travelerSelectorLabel.get(i).getText().contains(passenger))
                travelerSelectorInput.get(i).sendKeys(numberOfPassenger);
        }
    }

    public void clickOnCabinTypeOption(String optionText) {
        for (WebElement element : cabinTypeOptions) {
            if (element.getText().contains(optionText)) {
                element.click();
                break;
            }
        }
    }


}
