package drivers;
import data_storage.StoreDataIO;
import online_store_group_project.*;
import java.util.*;
import java.util.Scanner;



public class Driver1_newStoreStructure {
	
	public static void main(String args[]) {
		
		//Create Store   
		Store s1 = new Store();  
		 
	    //Create Customers 
		Customer c1 = new Customer(s1, "joethebro1997", "joe@gmail.com", "Joe", "Shmo", "joespass");
		Customer c2 = new Customer(s1, "mattthebro1997", "matt@mchsi.com", "Matt", "Marshall", "mattyice");
		Customer c3 = new Customer(s1, "Peterthebro1997", "Peter@hotmail.com", "Peter", "Piper", "PipingInTheName");
		Customer c4 = new Customer(s1, "Jakethebro1997", "Jake@gmail.com", "Jake", "Snake", "JakeTheSnake");
		Customer c5 = new Customer(s1, "AmandaCamanda111", "AmandaCamanda111@gmail.com", "Amanda", "Commonfield", "AmandaCamanda11");
		Customer c6 = new Customer(s1, "JessicaPeebs", "JessicaPeebs@hotmail.com", "Jessica", "Peebles", "Peebs123");
		Customer c7 = new Customer(s1, "FrankTheTank", "FrankTheTank@mchsi.com", "Frank", "Jeremy", "FrankTheTank4");
		Customer c8 = new Customer(s1, "SilvesterStilone", "Silvester@mchsi.com", "Silvester", "Stilone", "Silvertails");
		Customer c9 = new Customer(s1, "Skyballer", "Skyballer123@gmail.com", "Kanye", "Jamison", "Skyballer1");
		Customer c10 = new Customer(s1, "MagicMan", "MagicMan3@hotmail.com", "Bob", "White", "BobbyBoi");
		Customer c11 = new Customer(s1, "LilPeep", "16lines@gmail.com", "Harry", "Stemling", "Lilpeepfan2");
		Customer c12 = new Customer(s1, "AdrianPeterson", "YoAdrian@forestry.com", "Adrian", "Peterson", "AdrianPetersonTheGoat");
		Customer c13 = new Customer(s1, "FellInLove", "AmandaPeterson1@example.com", "Amanda", "Petterson", "Iloveboys");
		Customer c14 = new Customer(s1, "BobbyBrown", "BobbyBrown@Gmail.com", "Bobby", "Brown", "BobbyBoy");
		Customer c15 = new Customer(s1, "FlexMaster", "Johnathan@hotmail.com", "Johnathan", "Flitterson", "Johmmymommy");
		Customer c16 = new Customer(s1, "AmbushCrew", "AmberJones@example.com", "Amber", "Johnes", "Ambbbeerrrr");
		Customer c17 = new Customer(s1, "NickiMinajjj", "Nicki@gmail.com", "Nicki", "Minaj", "Nickiiiii");
		Customer c18 = new Customer(s1, "MirandaCosgrove", "Miranda@example.com", "Miranda", "Cosgrove", "Catlady");
		Customer c19 = new Customer(s1, "AmandaFellows", "AmandasIsAmazing@example.com", "Amanda", "Fellows", "chrisWayne");
		Customer c20 = new Customer(s1, "JimmyBean", "CelticsFan@example.com", "Jimmy", "Carter", "JimmyCArter");
		Customer c21 = new Customer(s1, "AndrewWhitfield", "Andybandy@example.com", "Andrew", "Whitfield", "Andyyyy");
		Customer c22 = new Customer(s1, "JenniferLawerence", "JennyLaur@example.com", "Jennifer", "Lawerence", "ForTHeFans");
		Customer c23 = new Customer(s1, "MagicMan", "MagicJohnson@example.com", "Magic", "Johnson", "43pointballer");
		Customer c24 = new Customer(s1, "MichaelJordan", "MichaelJordan@example.com", "Michael", "Jordan", "MisterSister");
		Customer c25 = new Customer(s1, "AndrewCarp", "AndrewCarpenter@example.com", "Andrew", "Carp", "WindyDay");
		Customer c26 = new Customer(s1, "TaylorFranklin", "TaylorFranklin@example.com", "Taylor", "Franklin", "TayTaysDay");
		Customer c27 = new Customer(s1, "Illenium", "Illenium@example.com", "Illenium", "God", "IlleniumMusic1");
		Customer c28 = new Customer(s1, "PhillipHarrison", "PhillipHarrison@example.com", "Phillip", "Harrison", "PhillipHarrison22");
		Customer c29 = new Customer(s1, "JimboGump", "Jimmy@example.com", "Jimbo", "Gump", "art");
		Customer c30 = new Customer(s1, "TiaNew", "Tia@example.com", "Tia", "New", "tipsymipsy");
		Customer c31 = new Customer(s1, "HenryFord", "henryFord@example.com", "Henry", "Ford", "HenryFord2");

		
		//Create Owners 
		Owner o1 = new Owner(s1, "RobertSacre", "robert@example.com", "Robert", "Sacre", "SacreTheGod"); 
		Owner o2 = new Owner(s1, "ComputerGuys", "Computers@example.com", "Alexander", "Computer", "CompSciSci"); 
		Owner o3 = new Owner(s1, "SlickApparel", "FancyApparel@example.com", "Bob", "Aparrel", "CoatsShoesAndDudes"); 
		Owner o4 = new Owner(s1, "BeautySuppliers", "beautifulwomen@example.com", "Marie", "Taylor", "Beauty123"); 
		Owner o5 = new Owner(s1, "VideoGameMasters", "VideoJuegos@example.com", "Jimmy", "Carter", "CarterTown"); 
		Owner o6 = new Owner(s1, "RaveArtists", "RaveArtists@example.com", "Yesica", "Tayler", "Yesicas4"); 
		Owner o7 = new Owner(s1, "OfficeMosers", "OfficeMosers@example.com", "Horace", "Mann", "Horaster"); 
		Owner o8 = new Owner(s1, "HomeTownRebels", "HomeTownRebels@example.com", "Bob", "Brown", "Bobbyyy"); 
		Owner o9 = new Owner(s1, "CollectionStirPot", "CollectionStirPot@example.com", "Hector", "Juice", "HectorTheCollecter"); 
		Owner o10 = new Owner(s1, "FoodFanatic", "FoodFanatic@example.com", "Fat", "Larry", "Larrrry"); 
		Owner o11 = new Owner(s1, "SportingGood", "SportingGood@example.com", "Vince", "Carter", "55"); 
		Owner o12 = new Owner(s1, "JediKnights", "JediKnights@example.com", "Annikan", "Skywalker", "JedisRule"); 
		Owner o13 = new Owner(s1, "MusicallyGifted", "MusicallyGifted@example.com", "Peggy", "Cabot", "GrandmasBack"); 
		Owner o14 = new Owner(s1, "TheGreatOutdoors", "TheGreatOutdoors@example.com", "Andy", "Violin", "BeautifulAndy"); 
		Owner o15 = new Owner(s1, "CreativeGeniuses", "CreativeGeniuses@example.com", "Nick", "Hanson", "Reds"); 
		Owner o16 = new Owner(s1, "SmokingMachines", "SmokingMachines@example.com", "Peter", "Leader", "Runitup"); 
		Owner o17 = new Owner(s1, "SafteyFirst", "SafteyFirst@example.com", "Saferty", "Maverick", "Saverly"); 
		Owner o18 = new Owner(s1, "Fantasia", "Fantasia@example.com", "Unusal", "Betsy", "Comeonemom"); 
		Owner o19 = new Owner(s1, "ToolsMans", "ToolsMans@example.com", "George", "Bimble", "GeorgyBimble"); 
		Owner o20 = new Owner(s1, "CollegeGoods", "CollegeGoods@example.com", "Harrison", "Who", "WOO"); 
		Owner o21 = new Owner(s1, "KitchenMans", "KitchenMans@example.com", "Chong", "Woo", "Chongking"); 
		Owner o22 = new Owner(s1, "VehicleMable", "VehicleMable@example.com", "John", "Mayer", "IIIII"); 
		Owner o23 = new Owner(s1, "SecretsAreNoFun", "SecretsAreNoFun@example.com", "Jerry", "Ferry", "JerryFerry"); 
		Owner o24 = new Owner(s1, "ProjectsOnProjects", "ProjectsOnProjects@example.com", "Howard", "Ford", "Howddd");  //
		Owner o25 = new Owner(s1, "HoldON", "HoldON@example.com", "Jin", "Stin", "sinner"); 
		Owner o26 = new Owner(s1, "BringTheSauce", "BringTheSauce@example.com", "Sam", "Mader", "FlavorTown"); 
		Owner o27 = new Owner(s1, "CountItUp", "CountItUp@example.com", "Guy", "Fierri", "OriginalFlavorTown"); 
		Owner o28 = new Owner(s1, "TellEM", "TellEM@example.com", "Alexa", "Gordon", "AlexaGordon"); 
		Owner o29 = new Owner(s1, "ServicePlease", "ServicePlease@example.com", "Mary", "Poppins", "Marrysss"); 
		Owner o30 = new Owner(s1, "Strumming", "Strumming@example.com", "Bless", "Hope", "Bleessss"); 
		
		
		//Create Categories 
		String cg1 = "Other"; 
		String cg2 = "Computers"; 
		String cg3 = "Electronic Accessories"; 
		String cg4 = "Shoes"; 
		String cg5 = "Shirts"; 
		String cg6 = "Beauty"; 
		String cg7 = "Video Games"; 
		String cg8 = "Rave Apparel";
		String cg9 = "Office Accessories";
		String cg10 = "Home Goods";
		String cg11 = "Collectables";
		String cg12 = "Food";
		String cg13 = "Sporting";
		String cg14 = "Star Wars";
		String cg15 = "Music";
		String cg16 = "Outdoors";
		String cg17 = "Creative";
		String cg18 = "Smoking Accessories";
		String cg19 = "Safety Gear";
		
		
		//Sample Item
		Item i24 = new Item(s1, o4, "" , "" , cg6, 45.00, 6);
		//Create Items
		//Initial Items 
		Item i1 = new Item(s1, o1, "American Flag" , "Large American Flag" , cg1, 16.00, 1);
		Item i2 = new Item(s1, o2, "HP Spectre" , "It has a solid state drive, sleek and fast!" , cg2, 2000.00, 2);    
		Item i3 = new Item(s1, o2, "Computer Mouse" , "Adjustable HP mouse but does not come with mouse pad" , cg3, 3.00, 8);
		Item i4 = new Item(s1, o3, "2017 Black Jordans" , "Shoes that will make you jump higher!" , cg4, 120.00, 1);
		Item i5 = new Item(s1, o3, "White T-shirt" , "Brand new White Ts" , cg5, 8.00, 7);
		Item i6 = new Item(s1, o4, "Lip Gloss" , "Bright pink lip gloss" , cg6, 20.00, 2);
		Item i7 = new Item(s1, o5, "Madden 2018" , "The newest Football Video Game on the Market!" , cg7, 50.00, 4);
		
		//Items in Other Category
		Item i9 = new Item(s1, o1, "Astroid" , "Fallen fresh from Mars. Only 2 in stock!" , cg1, 1000000.00, 2);
		Item i10 = new Item(s1, o1, "Odesza's Hair" , "Cut Fresh From EDM artist Odesza's lead song singer!" , cg1, 1000.00, 1);
		Item i11 = new Item(s1, o1, "Frog Poison" , "Collected fresh from the toads of Africa! Sold In jars. " , cg1, 200.00, 4);
		Item i12 = new Item(s1, o1, "Purple Emeralds" , "Found in the Caves of Egypt. Real Stones!" , cg1, 2000.00, 7);
		Item i13 = new Item(s1, o1, "Green Sculpture" , "Created by the man himself." , cg1, 23000.00, 1);
		
		//Items in Computers Category
		Item i14 = new Item(s1, o2, "MacBook Pro" , "256 GB and it comes with a case!" , cg2, 2000.00, 20);
		Item i15 = new Item(s1, o2, "Apple Table" , "Light Weight and highly Affordable!" , cg2, 1125.00, 5);
		Item i16 = new Item(s1, o2, "Windows 8 Desktop" , "Works Very well for completing programming projects!" , cg2, 678.00, 4);
		Item i17 = new Item(s1, o2, "Windows 7 Desktop" , "Older verson of The windows 8 but is a great price!" , cg2, 550.00, 67);
		Item i18 = new Item(s1, o2, "Zoom PC" , "Newest Computer on the market. It allows for 3D imaging capabilities and other functions!" , cg2, 5500.00, 18);
		
		//Items in Electronic Accessories Category
		Item i19 = new Item(s1, o24, "MousePad" , "Black MousePad" , cg3, 5.00, 23);
		Item i20 = new Item(s1, o24, "Pink Mouse" , "Extremely sleek and Wireless" , cg3, 20.00, 7);
		Item i21 = new Item(s1, o24, "Beats HeadPhones" , "Authentic Dr.Dre Headphones, and Brand new!" , cg3, 145.00, 13);
		Item i22 = new Item(s1, o24, "Apple HeadPhones" , "Wireless white apple Headphones!" , cg3, 13.00, 8);
		Item i23 = new Item(s1, o24, "Screen Protector" , "Clear Screen Protector" , cg3, 1.00, 102);
		
		//Items in Shoes Category
		Item i25 = new Item(s1, o3, "K-swiss Running Shoes" , "Comfortable running shoes that come in tan and silver" , cg4, 67.00, 6);
		Item i26 = new Item(s1, o3, "Slippers" , "Yellow and red bedtime slippers" , cg4, 32.00, 58);
		Item i27 = new Item(s1, o3, "Flip Flops" , "These are great Summertime flops in all sizes!" , cg4, 10.00, 10);
		Item i28 = new Item(s1, o3, "Addidas Sneakers" , "Blue Sneakers for anything." , cg4, 49.00, 90);
		
		//Items in Shirts Category
		Item i29 = new Item(s1, o25, "Rose Shirt" , "Black Shirt with a pink rose pocket!" , cg5, 20.00, 18);
		Item i30 = new Item(s1, o25, "Money Shirt" , "Collard shirt with benjamins on it!" , cg5, 79.00, 3);
		Item i31 = new Item(s1, o25, "Banana Shirt" , "Banana pattern along the entire shirt" , cg5, 60.00, 9);
		Item i32 = new Item(s1, o25, "Flower Shirt" , "Stripped Flowers along the front of the shirt" , cg5, 10.00, 9);
		Item i33 = new Item(s1, o25, "Purple Dress Shirt" , "Long Sleeves with gray buttons" , cg5, 100.00, 1);
		
		//Items in Beauty Category
		Item i34 = new Item(s1, o4, "Hair Product" , "Smells like apples." , cg6, 45.00, 6);
		Item i35 = new Item(s1, o4, "Hair Styler" , "Helps straighten and curl your hair." , cg6, 45.00, 6);
		Item i36 = new Item(s1, o4, "Eye Shadow" , "Perfect for dark nights." , cg6, 20.00, 6);
		Item i37 = new Item(s1, o4, "Eye Highlighter" , "Any color to accent your lips." , cg6, 23.00, 6);
		Item i38 = new Item(s1, o4, "Hair Dryer" , "100 watts of power and wireless" , cg6, 89.00, 6);
		
		//Items in Video Games Category
		Item i39 = new Item(s1, o5, "NHL" , "Newest version of professional hockey game" , cg7, 50.00, 9);
		Item i40 = new Item(s1, o5, "BO4" , "First person shooter, really fun!" , cg7, 30.00, 17);
		Item i41 = new Item(s1, o5, "Poker" , "No limit holdem, Omaha, and other features!" , cg7, 19.99, 7);
		Item i42 = new Item(s1, o5, "Mario" , "Oldest version of mario for Atari." , cg7, 20.00, 4);
		Item i43 = new Item(s1, o5, "Fifa" , "soccer Game" , cg7, 12.00, 10);
		
		//Items in Rave Apparel Category
		Item i44 = new Item(s1, o6, "Bandana" , "Comes in all patterns and colors." , cg8, 5.00, 18);
		Item i45 = new Item(s1, o6, "Colidascopes" , "Trippy ass glasses." , cg8, 20.00, 100);
		Item i46 = new Item(s1, o6, "Gum" , "Chewing gum for your jaw." , cg8, 1.00, 5);
		Item i47 = new Item(s1, o6, "CamelBackpack" , "Refillable with water" , cg8, 30.00, 34);
		Item i48 = new Item(s1, o6, "Candy" , "Bracelets with inscriptions on them." , cg8, 12.99, 42);
		
		//Items in Office Accessories Category
		Item i49 = new Item(s1, o7, "Pencils" , "10 packs of number 2 pencils" , cg9, 2.00, 6);
		Item i50 = new Item(s1, o7, "Pens" , "Blue and black" , cg9, 3.00, 6);
		Item i51 = new Item(s1, o7, "Post-it Notes" , "any color good for notew!" , cg9, 4.00, 6);
		Item i52 = new Item(s1, o7, "Stapler" , "Black and white stapler" , cg9, 5.00, 6);
		Item i53 = new Item(s1, o7, "Staples" , "For Stapler" , cg9, 5.00, 6);
		
		//Items in Home Goods Category
		Item i54 = new Item(s1, o8, "Lamp Shade" , "Great for any size lamp." , cg10, 30.00, 10);
		Item i55 = new Item(s1, o8, "Couch Cushion" , "striped, black cushion for your living room!" , cg10, 30.00, 10);
		Item i56 = new Item(s1, o8, "Chair" , "Kitchen chair for your table." , cg10, 50.00, 10);
		Item i57 = new Item(s1, o8, "Love Seat" , "Round pink love seat that sits two." , cg10, 30.00, 10);
		Item i58 = new Item(s1, o8, "Black Rug" , "Huge black rug" , cg10, 20.00, 10);
		
		//Items in Collectables Category
		Item i59 = new Item(s1, o9, "Tim Baseball Card" , "Mint Condition" , cg11, 100.00, 5);
		Item i60 = new Item(s1, o9, "Madden Bobble Head" , "Small madden bobble head." , cg11, 100.00, 5);
		Item i61 = new Item(s1, o9, "Russel Brown Trophy" , "HandMade in England." , cg11, 100.00, 5);
		Item i62 = new Item(s1, o9, "Jimmy Carter Shoes" , "Worn by professional basketball player Jimmy Carter!" , cg11, 100.00, 5);
		Item i63 = new Item(s1, o9, "John Wall Signed Poster" , "Signed by john wall after his pro season!" , cg11, 100.00, 5);
		
		//Items in Food Category
		Item i64 = new Item(s1, o10, "Hamburger" , "Grilled Hamburger with lettuce." , cg12, 5.00, 19);
		Item i65 = new Item(s1, o10, "Snickers Bar" , "Delicious snickers candy bar." , cg12, 5.00, 19);
		Item i66 = new Item(s1, o10, "Twix Bar" , "Yummy Twix Bar!" , cg12, 5.00, 19);
		Item i67 = new Item(s1, o10, "Corn Dogs" , "Comes with packets of ketchup and mustard" , cg12, 5.00, 19);
		Item i68 = new Item(s1, o10, "Southwest Salad" , "Fresh Tossed Greens!" , cg12, 5.00, 19);
		
		//Items in Sporting Category
		Item i69 = new Item(s1, o11, "Basketballs" , "Spalding orange Basketballs" , cg13, 15.00, 6);
		Item i70 = new Item(s1, o11, "Footballs" , "Brand new Footballs" , cg13, 15.00, 6);
		Item i71 = new Item(s1, o11, "Soccerballs" , "Brand new SoccerBalls" , cg13, 15.00, 6);
		Item i72 = new Item(s1, o11, "Baseballs" , "Brand new Baseballs" , cg13, 15.00, 6);
		Item i73 = new Item(s1, o11, "Tennisballs" , "Brand new TennisBalls" , cg13, 15.00, 6);
		
		//Items in Star Wars Category
		Item i74 = new Item(s1, o12, "Yoda BobbleHead" , "One foot tall yoda bobble head!" , cg14, 32.00, 4);
		Item i75 = new Item(s1, o12, "LightSaber" , "Real powered LightSaber!" , cg14, 32.00, 4);
		Item i76 = new Item(s1, o12, "Yoda Poster" , "Life Size poster of yoda." , cg14, 32.00, 4);
		Item i77 = new Item(s1, o12, "Ring" , "Ring that luke skywalker used to wear!" , cg14, 32.00, 4);
		Item i78 = new Item(s1, o12, "Millenium Falcon" , "Lego model of the real thing." , cg14, 32.00, 4);
		
		//Items in Music Category
		Item i79 = new Item(s1, o13, "Eminem Disk Track" , "Includes all of eminems songs he ever made!" , cg15, 45.00, 6);
		Item i80 = new Item(s1, o13, "Rhianna ear buds" , "Rhianna's face is on these ear buds!" , cg15, 45.00, 6);
		Item i81 = new Item(s1, o13, "Guitar" , "Brand new Guitar!" , cg15, 78.00, 6);
		Item i82 = new Item(s1, o13, "Electric Guitar" , "Comes with an amp." , cg15, 60.00, 6);
		Item i83 = new Item(s1, o13, "Mixing Board" , "Fully compatible with any device. Make your own beats!" , cg15, 200.00, 6);
	
		//Items in Outdoors Category
		Item i84 = new Item(s1, o14, "Black Tent" , "Comes with stakes and good for any weather" , cg16, 70.00, 10);
		Item i85 = new Item(s1, o14, "SwimSuit" , "Men's Corana patterened swimsuit!" , cg16, 20.00, 10);
		Item i86 = new Item(s1, o14, "Lighter Fluid" , "Fluid to help you start your fire!" , cg16, 30.00, 10);
		Item i87 = new Item(s1, o14, "Pocket Knife" , "Swiss Army Pocket knife good for cutting fish!" , cg16, 6.00, 10);
		Item i88 = new Item(s1, o14, "Matches" , "15 pack" , cg16, 5.00, 10);
		
		//Items in Creative Category
		Item i89 = new Item(s1, o15, "Paint Pallete" , "Artistic Paint pallet for artists." , cg17, 7.99, 6);
		Item i90 = new Item(s1, o15, "Paint brushes" , "Set of 4 paint brushes" , cg17, 7.99, 6);
		Item i91 = new Item(s1, o15, "Art Canvas" , "large blank white canvas for painting." , cg17, 7.99, 6);
		Item i92 = new Item(s1, o15, "Brush Tips" , "All different sizes" , cg17, 7.99, 6);
		
		//Items in Smoking Accessories Category
		Item i93 = new Item(s1, o16, "Bong" , "Tall 4 chamber Bong." , cg18, 22.00, 4);
		Item i94 = new Item(s1, o16, "Rolling Papers" , "Raw 5 pack of rolling papers." , cg18, 22.00, 4);
		Item i95 = new Item(s1, o16, "Lighter" , "Rainbow colored 4 pack of lighters" , cg18, 22.00, 4);
		
		//Items in Safety Gear Category
		Item i96 = new Item(s1, o17, "Helmet" , "Heavy Duty Bicycle all purpose bicycle helmet" , cg19, 32.00, 6);
		Item i97 = new Item(s1, o17, "Knee Pads" , "large knee pads for any sport" , cg19, 32.00, 6);
		Item i98 = new Item(s1, o17, "Safety Goggles" , "Clear Safety Glasses" , cg19, 32.00, 6);
		Item i99 = new Item(s1, o17, "Contacts lens" , "Clear Contact lens" , cg19, 32.00, 6);
		Item i100 = new Item(s1, o17, "Harness" , "Safety Harness for rockclimbing" , cg19, 32.00, 6);
		
		//Add Items to their respective owner
		o1.addItem(i1); 
		o1.addItem(i9); 
		o1.addItem(i10); 
		o1.addItem(i11); 
		o1.addItem(i12); 
		o1.addItem(i13); 
		
		o2.addItem(i14); 
		o2.addItem(i15); 
		o2.addItem(i16); 
		o2.addItem(i17); 
		o2.addItem(i18); 
		o2.addItem(i3); 
		o3.addItem(i24); 
		o3.addItem(i25);
		o3.addItem(i26);
		o3.addItem(i27);
		o3.addItem(i28);
		o3.addItem(i5); 
		
		o4.addItem(i34); 
		o4.addItem(i35);
		o4.addItem(i36);
		o4.addItem(i37);
		o4.addItem(i38);
		
		o5.addItem(i39); 
		o5.addItem(i40); 
		o5.addItem(i41); 
		o5.addItem(i42); 
		o5.addItem(i43); 
		
		o6.addItem(i44); 
		o6.addItem(i45);
		o6.addItem(i46);
		o6.addItem(i47);
		o6.addItem(i48);
		
		o7.addItem(i49);
		o7.addItem(i50);
		o7.addItem(i51);
		o7.addItem(i52);
		o7.addItem(i53);
		
		o8.addItem(i54);
		o8.addItem(i55);
		o8.addItem(i56);
		o8.addItem(i57);
		o8.addItem(i58);
		
		o9.addItem(i59);
		o9.addItem(i60);
		o9.addItem(i61);
		o9.addItem(i62);
		o9.addItem(i63);
		
		o10.addItem(i64);
		o10.addItem(i65);
		o10.addItem(i66);
		o10.addItem(i67);
		o10.addItem(i68);
		
		o11.addItem(i69);
		o11.addItem(i70);
		o11.addItem(i72);
		o11.addItem(i73);
		o11.addItem(i74);
		
		o12.addItem(i75);
		o12.addItem(i76);
		o12.addItem(i77);
		o12.addItem(i78);
		
		o13.addItem(i79);
		o13.addItem(i80);
		o13.addItem(i81);
		o13.addItem(i82);
		o13.addItem(i83);
		
		o14.addItem(i84);
		o14.addItem(i85);
		o14.addItem(i86);
		o14.addItem(i87);
		o14.addItem(i88);
		
		o15.addItem(i89);
		o15.addItem(i90);
		o15.addItem(i91);
		o15.addItem(i92);
		
		o16.addItem(i93);
		o16.addItem(i94);
		o16.addItem(i95);
		
		o17.addItem(i96);
		o17.addItem(i97);
		o17.addItem(i98);
		o17.addItem(i99);
		o17.addItem(i100);
		
		//Add All Users to the Store 
		s1.owners.add(o1); 
		s1.owners.add(o2);
		s1.owners.add(o3);
		s1.owners.add(o4);
		s1.owners.add(o5);
		s1.owners.add(o6);
		s1.owners.add(o7);
		s1.owners.add(o8);
		s1.owners.add(o9);
		s1.owners.add(o10);
		s1.owners.add(o11);
		s1.owners.add(o12);
		s1.owners.add(o13);
		s1.owners.add(o14);
		s1.owners.add(o15);
		s1.owners.add(o16);
		s1.owners.add(o17);
		s1.owners.add(o18);
		s1.owners.add(o19);
		s1.owners.add(o20);
		s1.owners.add(o21);
		s1.owners.add(o22);
		s1.owners.add(o23);
		s1.owners.add(o24);
		s1.owners.add(o25);
		s1.owners.add(o26);
		s1.owners.add(o27);
		s1.owners.add(o28);
		s1.owners.add(o29);
		s1.owners.add(o30);
		
		s1.customers.add(c1); 
		s1.customers.add(c2);
		s1.customers.add(c3);
		s1.customers.add(c4);
		s1.customers.add(c5);
		s1.customers.add(c6);
		s1.customers.add(c7);
		s1.customers.add(c8);
		s1.customers.add(c9);
		s1.customers.add(c10);
		s1.customers.add(c11);
		s1.customers.add(c12);
		s1.customers.add(c13);
		s1.customers.add(c14);
		s1.customers.add(c15);
		s1.customers.add(c16);
		s1.customers.add(c17);
		s1.customers.add(c18);
		s1.customers.add(c19);
		s1.customers.add(c20);
		s1.customers.add(c21);
		s1.customers.add(c22);
		s1.customers.add(c23);
		s1.customers.add(c24);
		s1.customers.add(c25);
		s1.customers.add(c26);
		s1.customers.add(c27);
		s1.customers.add(c28);
		s1.customers.add(c29);
		s1.customers.add(c30);
		s1.customers.add(c31);
		
		Order order = new Order();
		order.setBuyer(c1);
		order.setSeller(o1);
		order.addItem(i1);
		order.setTimestamp(new Date());
		c1.addOrder(order);
		
		StoreDataIO.storeStoreData(s1);
		
		
		//Testing all functions in the Store Class 
		System.out.println("Test for getting the Categories, Items in a Category, all Items, and featured Items:"); 
		System.out.println(""); 
		
	    ArrayList<Category> Categories = new ArrayList<Category>(); 
	    ArrayList<Item> Items = new ArrayList<Item>(); 

		
	    System.out.println("Print All Categories:"); 
	    for(String c : s1.getCategories()) System.out.println(c);
	    
		System.out.println("Print Items in the Category-> Computers:"); 
	    for(Item i : s1.getItemsInCategory("Computers")) System.out.println(i.getName());
	    System.out.println(""); 
		
	    Items = s1.getAllItems(); 
	    
	    System.out.println("Print All Items:"); 
	    for(int i = 0; i < Items.size(); i++) {
	    System.out.println(Items.get(i).getName());
	    }
	    System.out.println(""); 
	    
	    Items = s1.getFeaturedItems(); 
	    
	    System.out.println("Print Featured Items:"); 
	    for(int i = 0; i < Items.size(); i++) {
	    System.out.println(Items.get(i).getName());
	    }
	    System.out.println(""); 
	    
	    //Test User Exists Function in Store 
	    System.out.println("Testing already taken user email address and username:");
	    
	    System.out.println(""); 
	    
	    //Test Item Exists Function in Store 
	    System.out.println("Testing item with same name:");
	    
	    Item i8 = new Item(s1, o5, "Madden 2018" , "The newest Football Video Game on the Market!" , cg7, 50.00, 4);
	    System.out.println(""); 
	    
	    //Testing Sorting Featured Items Alphabetically 
	    ArrayList<String> itemNames = new ArrayList<String>();
	    for(Item i : s1.items) itemNames.add(i.getName());
	    
	    Collections.sort(itemNames);
	    
	    System.out.println("Sorted Featured Items:"); 
	    for(int i = 0; i < itemNames.size(); i++) {
	    System.out.println(itemNames.get(i));
	    }
	    System.out.println(""); 

		
		
		//Enter the Online Store with guided user inputs 
		while(true) {

		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Do you want to enter the Online Store (yes/no)?:");
		String input = reader.nextLine();
			
		if(input.equals("yes")) {
			
			int inputInteger = 0;
			while(inputInteger < 1 || inputInteger > 3) {
			Scanner reader1 = new Scanner(System.in); 
			System.out.println("Do you want to search(1), browse categories(2), or view featured items(3)?:");	
		    inputInteger = reader1.nextInt(); 
		    
		    if(inputInteger == 1) {  //search Entire Store 
		        System.out.println("Search online store by Item name:");
		        String input1 = reader1.nextLine();
		        
		    }
		    else if(inputInteger == 2) { //Browse through the Categories 
	
		    	
		    	Scanner reader2 = new Scanner(System.in); 
		        System.out.println("These are all the available Categories:");
		    	for(String c : s1.getCategories())System.out.println(c);
		    	
		    	System.out.println("Choose a category:");   
		    	String categoryName = reader2.nextLine(); 
		    	
		    	while(!s1.getCategories().contains(categoryName)) {
		    		System.out.println("Category " + categoryName + "does not exist. Please choose another category." );
			    	categoryName = reader2.nextLine(); 
			    	
		    	}
		    	
		        System.out.println("These are all the available items in category " + categoryName + ":");
		    	for(Item i : s1.getItemsInCategory(categoryName)) System.out.println(i.getName());
		    	
		    	System.out.println("Choose an item:");   
		    	String itemName = reader2.nextLine(); 
		    	
		    	while(s1.searchItems(itemName).size() < 1) {
		    		System.out.println("Item " + itemName + "does not exist. Please choose another category." );
			    	itemName = reader2.nextLine(); 
		    	}
	
		    	Item chosenItem = s1.searchItems(itemName).get(0);
		        Item.printItemInfo(chosenItem);
		    	
		    	}  	
		      } 
	    	}      
			else {
				System.out.println("Have a Nice Day!");	
			}
		}
	}
}
