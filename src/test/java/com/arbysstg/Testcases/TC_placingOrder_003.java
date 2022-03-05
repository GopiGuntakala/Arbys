package com.arbysstg.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.arbysstg.pageobjects.BagObjects;
import com.arbysstg.pageobjects.CheckoutPageObjects;
import com.arbysstg.pageobjects.HomepageObjects;
import com.arbysstg.pageobjects.LocationPageObjects;
import com.arbysstg.pageobjects.MenuPageObjects;
import com.arbysstg.pageobjects.PDPPageObjects;
import com.arbysstg.pageobjects.PLPPageObjects;

public class TC_placingOrder_003 extends BaseClass {

	
	HomepageObjects homep;
	LocationPageObjects locationP;
	MenuPageObjects MenuP;
	PLPPageObjects PLPPage;
	PDPPageObjects PDPPage;
	BagObjects bag;
	CheckoutPageObjects checkp;
	
	
	
	@Test
	public void placingOrder() throws IOException, InterruptedException {
		
		homep=new HomepageObjects(driver);
		locationP=new LocationPageObjects(driver);
		MenuP=new MenuPageObjects(driver);
		PLPPage=new PLPPageObjects(driver);
		PDPPage=new PDPPageObjects(driver);
		bag=new BagObjects(driver);
		checkp=new CheckoutPageObjects(driver);
		
		log.info("launchin url");
		homep.closeCookies();
		log.info("closing cookies");
		homep.StartAnorderBtn();
		log.info("Selecting start an order button");
		locationP.SearchBox("35233");
		log.info("Entering zipcode");
		locationP.searchstore();
		log.info("Searchig the zipcode");
		locationP.SelectStore();
		log.info("selecting store");
		MenuP.MealsCategory();
		log.info("selecting category");
		PLPPage.addProductPLP();
		log.info("selecting item in plp page");
		
		PDPPage.AddItemfromPDP();
		log.info("clicking on add to bag button on PDP page");
		Assert.assertEquals(bag.ItemaddTooltip(), "Item added to bag");
		log.info("validating tooltip");
		
		bag.OpenBag();
		log.info("opening bag");
		Assert.assertEquals(bag.ItemLevelPriceB(), bag.SubtoatlB());
		log.info("checking item price and subtotal");
		System.out.println(bag.ItemLevelPriceB());
		Assert.assertEquals(bag.TotalB(), bag.OverallTotalB());
		log.info("validating total and bag level total prices");
		System.out.println(bag.TotalB());
		System.out.println(bag.OverallTotalB());
		
		bag.CheckoutNow();
		log.info("clicking on checkout now button");
		log.info("Filling customer info details");
		CustomerInfoFill();
		
		log.info("Filling card holder details");
		CardHolderDetails();
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
