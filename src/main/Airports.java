package com.poortoys.examples;

public class Airports {
	
	public enum origin;
	public enum destination; 
	
	public Airports(enum origin, enum destination) {
		
		this.origin= origin;
		this.destination=destination;
		
	}
	
	
	public void selectOrigin (enum origin) {
		
		driver.findElement(By.cssSelector("body > am-home > div.searchbox > div.searchbox__content > am-search-box > div > div.search-box__formContainer > am-search-box-container > am-search-box-flights > div > form > div.flights-form__inputs-container > div > div.flights-form__inputs-container__content__input.flights-form__inputs-container__content__input--travel.on-mobile.on-mobile--block.ng-invalid.ng-touched.ng-dirty > am-group-inputs.on-desktop.on-desktop--mr-8.on-mobile.on-mobile--mb-8.flights-form__inputs-container__content__input--travel__autocomplete.on-mobile--block > div.on-desktop--flex-row.on-desktop--flex-1.on-mobile--flex-column > div:nth-child(1) > am-input-form-container"));
		
		
		
	}
	
	
	

}
