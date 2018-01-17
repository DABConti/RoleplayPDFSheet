/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfBorderDictionary;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.TextField;

public class TextFields implements PdfPCellEvent {

	/** The resulting PDF. */
    public static final String RESULT1 = "text_fields.pdf";
    /** The resulting PDF. */
    public static final String RESULT2 = "text_filled.pdf";
	
    /** The resulting PDF. */
    public static final String WHF = "whfCharacter";
    /** The resulting PDF. */
    public static final String WH40k = "40kCharacter";
    /** The resulting PDF. */
    public static final String CARME = "CarmeCharacter";
    
    public static final String NCS = "ncsCharacter";
    /** The text field index of a TextField that needs to be added to a cell. */
    protected String tf;

    /**
     * Creates a cell event that will add a text field to a cell.
     * @param tf a text field index.
     */
    public TextFields(String tf) {
        this.tf = tf;
    }
    
    public Phrase getDefaultPhrase(String txt) 
    {
		return new Phrase(txt, FontFactory.getFont(FontFactory.HELVETICA , 11));	
    }
    
    public Phrase getDefaultPhrase(String txt, int fontSize) 
    {
		return new Phrase(txt, FontFactory.getFont(FontFactory.HELVETICA , fontSize));	
    }
    
    public Phrase getDefaultPhrase(String txt, float fontSize) 
    {
		return new Phrase(txt, FontFactory.getFont(FontFactory.HELVETICA , fontSize));	
    }
    
    public ArrayList<ArrayList<NCSSkill>> getNCSSkills()
    {
    	ArrayList<ArrayList<NCSSkill>> retList = new ArrayList<>();
    	
    	ArrayList<NCSSkill> strengthSkills = new ArrayList<>();
    	ArrayList<NCSSkill> dexSkills = new ArrayList<>();
    	ArrayList<NCSSkill> mentalSkills = new ArrayList<>();
    	ArrayList<NCSSkill> charismaSkills = new ArrayList<>();
    	ArrayList<NCSSkill> willpowerSkills = new ArrayList<>();
    	
    	strengthSkills.add(new NCSSkill("Athletics", 0));
    	strengthSkills.add(new NCSSkill("Swim", 0));
    	strengthSkills.add(new NCSSkill("Health", 0));
    	strengthSkills.add(new NCSSkill("Axe", 0));
    	strengthSkills.add(new NCSSkill("Brawl", 0));
    	strengthSkills.add(new NCSSkill("Club", 0));
    	strengthSkills.add(new NCSSkill("Great Weapon", 0));
    	strengthSkills.add(new NCSSkill("Shield", 0));
    	strengthSkills.add(new NCSSkill("Bow", 0));
    	strengthSkills.add(new NCSSkill("Crossbow", 0));
    	strengthSkills.add(new NCSSkill("Daggers", 0));
    	strengthSkills.add(new NCSSkill("Pistols", 0));
    	strengthSkills.add(new NCSSkill("Rifles", 0));
    	strengthSkills.add(new NCSSkill("Sword", 0));
    	strengthSkills.add(new NCSSkill("Throwing", 0));
    	strengthSkills.add(new NCSSkill("Pole Weapon", 0));
    	
    	dexSkills.add(new NCSSkill("Acrobatics", 0));
    	dexSkills.add(new NCSSkill("Dodge", 0));
    	dexSkills.add(new NCSSkill("Lockpick", 0));
    	dexSkills.add(new NCSSkill("Pickpocket", 0));
    	dexSkills.add(new NCSSkill("Ride", 0));
    	dexSkills.add(new NCSSkill("Rope Work", 0));
    	dexSkills.add(new NCSSkill("Stealth", 0));
    	dexSkills.add(new NCSSkill("Traps", 0));
    	
    	mentalSkills.add(new NCSSkill("Academics", 0));
    	mentalSkills.add(new NCSSkill("Alchemy", 0));
    	mentalSkills.add(new NCSSkill("Ancient Lan", 0));
    	mentalSkills.add(new NCSSkill("Ancient Know", 0));
    	mentalSkills.add(new NCSSkill("Appraise", 0));
    	mentalSkills.add(new NCSSkill("Arcane Smith", 0));
    	mentalSkills.add(new NCSSkill("Bowyer", 0));
    	mentalSkills.add(new NCSSkill("Flethcer", 0));
    	mentalSkills.add(new NCSSkill("Clockwork", 0));
    	mentalSkills.add(new NCSSkill("Cartograpy", 0));
    	mentalSkills.add(new NCSSkill("Cooking", 0));
    	mentalSkills.add(new NCSSkill("Explosives", 0));
    	mentalSkills.add(new NCSSkill("First Aid", 0));
    	mentalSkills.add(new NCSSkill("Herbalism", 0));
    	mentalSkills.add(new NCSSkill("Legal Know", 0));
    	mentalSkills.add(new NCSSkill("Magic Know", 0));
    	mentalSkills.add(new NCSSkill("Monster Know", 0));
    	mentalSkills.add(new NCSSkill("Navigate", 0));
    	mentalSkills.add(new NCSSkill("Naval Tactics", 0));
    	mentalSkills.add(new NCSSkill("Spot", 0));
    	mentalSkills.add(new NCSSkill("Listen", 0));
    	mentalSkills.add(new NCSSkill("Smell", 0));
    	mentalSkills.add(new NCSSkill("Sail", 0));
    	mentalSkills.add(new NCSSkill("Species Know", 0));
    	mentalSkills.add(new NCSSkill("Steampunk", 0));
    	mentalSkills.add(new NCSSkill("Survival", 0));
    	mentalSkills.add(new NCSSkill("Tatics", 0));
    	mentalSkills.add(new NCSSkill("Theology", 0));
    	mentalSkills.add(new NCSSkill("Torture", 0));
    	mentalSkills.add(new NCSSkill("Tracking", 0));
    	mentalSkills.add(new NCSSkill("Trade", 0));
    	
    	charismaSkills.add(new NCSSkill("Bluff", 0));
    	charismaSkills.add(new NCSSkill("Criminal Savvy", 0));
    	charismaSkills.add(new NCSSkill("Empathy", 0));
    	charismaSkills.add(new NCSSkill("Haggle", 0));
    	charismaSkills.add(new NCSSkill("Intidate", 0));
    	charismaSkills.add(new NCSSkill("Merchant Savvy", 0));
    	charismaSkills.add(new NCSSkill("Performance", 0));
    	charismaSkills.add(new NCSSkill("Persuade", 0));
    	charismaSkills.add(new NCSSkill("Political Savvy", 0));
    	
    	willpowerSkills.add(new NCSSkill("Courage", 0));
    	willpowerSkills.add(new NCSSkill("Devotion", 0));
    	willpowerSkills.add(new NCSSkill("Resolve", 0));
    	willpowerSkills.add(new NCSSkill("Sense Magic", 0));
    	willpowerSkills.add(new NCSSkill("Witch Sight", 0));
    	willpowerSkills.add(new NCSSkill("Supress Aura", 0));
    	
    	Collections.sort(strengthSkills, new Comparator<NCSSkill>() {
    	    public int compare(NCSSkill lhs, NCSSkill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(dexSkills, new Comparator<NCSSkill>() {
    	    public int compare(NCSSkill lhs, NCSSkill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(mentalSkills, new Comparator<NCSSkill>() {
    	    public int compare(NCSSkill lhs, NCSSkill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(charismaSkills, new Comparator<NCSSkill>() {
    	    public int compare(NCSSkill lhs, NCSSkill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(willpowerSkills, new Comparator<NCSSkill>() {
    	    public int compare(NCSSkill lhs, NCSSkill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	
    	retList.add(strengthSkills);
    	retList.add(dexSkills);
    	retList.add(mentalSkills);
    	retList.add(charismaSkills);
    	retList.add(willpowerSkills);
    	
		return retList;
    }
    
    public ArrayList<ArrayList<Skill>> getFantasySkills()
    {
    	ArrayList<ArrayList<Skill>> retList = new ArrayList<>();
    	
    	ArrayList<Skill> strengthSkills = new ArrayList<>();
    	ArrayList<Skill> dexSkills = new ArrayList<>();
    	ArrayList<Skill> mentalSkills = new ArrayList<>();
    	ArrayList<Skill> charismaSkills = new ArrayList<>();
    	ArrayList<Skill> willpowerSkills = new ArrayList<>();
    	
    	strengthSkills.add(new Skill("Athletics", 3,0));
    	strengthSkills.add(new Skill("Axe", 4,0));
    	strengthSkills.add(new Skill("Brawl", 3, 0));
    	strengthSkills.add(new Skill("Climb", 2, 0));
    	strengthSkills.add(new Skill("Maces", 4, 0));
    	strengthSkills.add(new Skill("Shield", 3,0));
    	strengthSkills.add(new Skill("Swim", 2,0));
    	
    	
    	dexSkills.add(new Skill("Acrobatics", 2, 1));
    	dexSkills.add(new Skill("Bow", 4, 1));
    	dexSkills.add(new Skill("Crossbow", 3, 1));
    	dexSkills.add(new Skill("Dodge", 5, 1));
    	dexSkills.add(new Skill("Knives", 3, 1));
    	dexSkills.add(new Skill("Thievery", 3, 1));
    	dexSkills.add(new Skill("Pistols", 4, 1));
    	dexSkills.add(new Skill("Ride", 2, 1));
    	dexSkills.add(new Skill("Rifles", 4, 1));
    	dexSkills.add(new Skill("Rope work", 1, 1));
    	dexSkills.add(new Skill("Sling", 2, 1));
    	dexSkills.add(new Skill("Polearms", 3, 1));
    	dexSkills.add(new Skill("Stealth", 4, 1));
    	dexSkills.add(new Skill("Sword", 4, 1));
    	dexSkills.add(new Skill("Thrown Weapons", 3, 1));
    	
    	
    	mentalSkills.add(new Skill("Academics", 3, 2));
    	mentalSkills.add(new Skill("Alchemy", 5, 2));
    	mentalSkills.add(new Skill("Mercantilism", 3, 2));
    	mentalSkills.add(new Skill("Politicking", 3, 2));
    	mentalSkills.add(new Skill("Blacksmith", 3, 2));
    	mentalSkills.add(new Skill("Bowyer", 3, 2));
    	mentalSkills.add(new Skill("Forbidden Know.", 4, 2));
    	mentalSkills.add(new Skill("Cooking", 1, 2));
    	mentalSkills.add(new Skill("FirstAid", 3, 2));
    	mentalSkills.add(new Skill("Medicine", 4, 2));
    	mentalSkills.add(new Skill("Husbandry", 2, 2));
    	mentalSkills.add(new Skill("Herbalism", 2, 2));
    	mentalSkills.add(new Skill("Magic Know.", 4, 2));
    	mentalSkills.add(new Skill("Monster Know.", 3, 2));
    	mentalSkills.add(new Skill("Navigate", 2, 2));
    	mentalSkills.add(new Skill("Perception", 5, 2));
    	mentalSkills.add(new Skill("Naval Know.", 2, 2));
    	mentalSkills.add(new Skill("Survival", 2, 2));
    	mentalSkills.add(new Skill("Military Know.", 2, 2));
    	mentalSkills.add(new Skill("Engineering", 4, 2));
    	mentalSkills.add(new Skill("Traps", 2, 1));
    	mentalSkills.add(new Skill("Siege Weapons", 3, 1));
    	
    	charismaSkills.add(new Skill("Bluff", 2, 3));
    	charismaSkills.add(new Skill("Interrogate", 2, 3));
    	charismaSkills.add(new Skill("Empathy", 2, 3));
    	charismaSkills.add(new Skill("Haggle", 4, 3));
    	charismaSkills.add(new Skill("Intimidate", 3, 3));
    	charismaSkills.add(new Skill("Persuade", 3, 3));
    	charismaSkills.add(new Skill("Performance", 3, 3));
    	
    	Collections.sort(strengthSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(dexSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(mentalSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(charismaSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(willpowerSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	
    	retList.add(strengthSkills);
    	retList.add(dexSkills);
    	retList.add(mentalSkills);
    	retList.add(charismaSkills);
    	retList.add(willpowerSkills);
    	
		return retList;
    }
    
    public ArrayList<ArrayList<Skill>> get40kSkills()
    {
    	ArrayList<ArrayList<Skill>> retList = new ArrayList<>();
    	
    	ArrayList<Skill> strengthSkills = new ArrayList<>();
    	ArrayList<Skill> dexSkills = new ArrayList<>();
    	ArrayList<Skill> mentalSkills = new ArrayList<>();
    	ArrayList<Skill> charismaSkills = new ArrayList<>();
    	ArrayList<Skill> willpowerSkills = new ArrayList<>();
    	
    	strengthSkills.add(new Skill("Athletics", 3,0));
    	strengthSkills.add(new Skill("Axe", 3, 0));
    	strengthSkills.add(new Skill("Bastard Sword", 3, 0));
    	strengthSkills.add(new Skill("Brawl", 3, 0));
    	strengthSkills.add(new Skill("Climb", 2, 0));
    	strengthSkills.add(new Skill("Club", 2, 0));
    	strengthSkills.add(new Skill("Great Axe", 3, 0));
    	strengthSkills.add(new Skill("Great Maul", 3, 0));
    	strengthSkills.add(new Skill("Great Sword", 3, 0));
    	strengthSkills.add(new Skill("Slashing Sword", 2, 0));
    	strengthSkills.add(new Skill("Shield", 3,0));
    	strengthSkills.add(new Skill("Swim", 1,0));
    	strengthSkills.add(new Skill("Fist Weapons", 3,0));
    	
    	
    	dexSkills.add(new Skill("Acrobatics", 2, 1));
    	dexSkills.add(new Skill("Bow", 2, 1));
    	dexSkills.add(new Skill("Crossbow", 2, 1));
    	dexSkills.add(new Skill("Dodge", 5, 1));
    	dexSkills.add(new Skill("Knives", 2, 1));
    	dexSkills.add(new Skill("Lockpick", 2, 1));
    	dexSkills.add(new Skill("Pistols", 4, 1));
    	dexSkills.add(new Skill("Pickpocket", 2, 1));
    	dexSkills.add(new Skill("Ride", 1, 1));
    	dexSkills.add(new Skill("Rifles", 4, 1));
    	dexSkills.add(new Skill("Rope work", 1, 1));
    	dexSkills.add(new Skill("Sling", 1, 1));
    	dexSkills.add(new Skill("Spear", 3, 1));
    	dexSkills.add(new Skill("Stealth", 4, 1));
    	dexSkills.add(new Skill("Sword", 2, 1));
    	dexSkills.add(new Skill("Throwing Knives", 2, 1));
    	dexSkills.add(new Skill("Traps", 3, 1));
    	dexSkills.add(new Skill("Heavy Weapons", 4, 1));
    	dexSkills.add(new Skill("Drive", 2, 1));
    	dexSkills.add(new Skill("Pilot", 2, 1));
    	dexSkills.add(new Skill("Jetpacks", 2, 1));
    	dexSkills.add(new Skill("Flamers", 4, 1));
    	
    	
    	mentalSkills.add(new Skill("Academics", 2, 2));
    	mentalSkills.add(new Skill("Astrophysics", 3, 2));
    	mentalSkills.add(new Skill("Research", 3, 2));
    	mentalSkills.add(new Skill("Tech Repair", 4, 2));
    	mentalSkills.add(new Skill("Ancient Lang.", 2, 2));
    	mentalSkills.add(new Skill("Appraise", 3, 2));
    	mentalSkills.add(new Skill("Tech (General) ", 5, 2));
    	mentalSkills.add(new Skill("Tech Security", 4, 2));
    	mentalSkills.add(new Skill("Tech Fabrication", 4, 2));
    	mentalSkills.add(new Skill("Chaos Know.", 4, 2));
    	mentalSkills.add(new Skill("Cooking", 1, 2));
    	mentalSkills.add(new Skill("Craft", 0, 2));
    	mentalSkills.add(new Skill("FirstAid", 2, 2));
    	mentalSkills.add(new Skill("Medicine", 3, 2));
    	mentalSkills.add(new Skill("Explosives", 3, 2));
    	mentalSkills.add(new Skill("Animal Ken", 1, 2));
    	
    	mentalSkills.add(new Skill("Bioscience", 4, 2));
    	mentalSkills.add(new Skill("Legal Know.", 2, 2));
    	mentalSkills.add(new Skill("Xeno Know.", 4, 2));
    	mentalSkills.add(new Skill("Species Know.", 3, 2));
    	mentalSkills.add(new Skill("Navigate", 2, 2));
    	mentalSkills.add(new Skill("Observe", 4, 2));
   
    	mentalSkills.add(new Skill("Naval Tactics", 2, 2));
    	
    	mentalSkills.add(new Skill("Survival", 1, 2));
    	mentalSkills.add(new Skill("Tactics", 2, 2));
    	mentalSkills.add(new Skill("Torture", 2, 2));
    	mentalSkills.add(new Skill("Tracking", 2, 2));
    	mentalSkills.add(new Skill("Trade", 0, 2));
    	mentalSkills.add(new Skill("Theology", 3, 2));
    	mentalSkills.add(new Skill("Engineering", 4, 2));
    	
    	
    	charismaSkills.add(new Skill("Handle Animal", 1, 3));
    	charismaSkills.add(new Skill("Bluff", 2, 3));
    	charismaSkills.add(new Skill("Criminal Savvy", 2, 3));
    	charismaSkills.add(new Skill("Empathy", 2, 3));
    	charismaSkills.add(new Skill("Haggle", 4, 3));
    	charismaSkills.add(new Skill("Intimidate", 3, 3));
    	charismaSkills.add(new Skill("Merchant Savvy", 2, 3));
    	charismaSkills.add(new Skill("Persuade", 3, 3));
    	charismaSkills.add(new Skill("Xeno Savvy", 3, 3));
    	charismaSkills.add(new Skill("Polital Savvy", 2, 3));
    	charismaSkills.add(new Skill("Spacer Savvy", 2, 3));
    	charismaSkills.add(new Skill("Performance", 3, 3));
    	
    	willpowerSkills.add(new Skill("Courage", 3, 4));
    	willpowerSkills.add(new Skill("Devotion", 3, 4));
    	willpowerSkills.add(new Skill("Meditation", 2, 4));
    	
    	Collections.sort(strengthSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(dexSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(mentalSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(charismaSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(willpowerSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	
    	retList.add(strengthSkills);
    	retList.add(dexSkills);
    	retList.add(mentalSkills);
    	retList.add(charismaSkills);
    	retList.add(willpowerSkills);
    	
		return retList;
    }
    
    public ArrayList<ArrayList<Skill>> getCarimeSkills()
    {	
    	ArrayList<ArrayList<Skill>> retList = new ArrayList<>();
    	
    	ArrayList<Skill> strengthSkills = new ArrayList<>();
    	ArrayList<Skill> dexSkills = new ArrayList<>();
    	ArrayList<Skill> mentalSkills = new ArrayList<>();
    	ArrayList<Skill> charismaSkills = new ArrayList<>();
    	ArrayList<Skill> willpowerSkills = new ArrayList<>();
    	
    	strengthSkills.add(new Skill("Athletics", 3,0));
    	strengthSkills.add(new Skill("Axe", 4,0));
    	strengthSkills.add(new Skill("Bastard Sword", 4,0));
    	strengthSkills.add(new Skill("Brawl", 3, 0));
    	strengthSkills.add(new Skill("Climb", 2, 0));
    	strengthSkills.add(new Skill("Club", 3, 0));
    	strengthSkills.add(new Skill("Great Axe", 4, 0));
    	strengthSkills.add(new Skill("Great Maul", 4, 0));
    	strengthSkills.add(new Skill("Great Sword", 4,0));
    	strengthSkills.add(new Skill("Slashing Sword", 3,0));
    	strengthSkills.add(new Skill("Shield", 3,0));
    	strengthSkills.add(new Skill("Swim", 1,0));
    	strengthSkills.add(new Skill("Resilience", 2,0));
    	//strengthSkills.add(new Skill("Warrior's Physique", 3,0));
    	
    	
    	dexSkills.add(new Skill("Acrobatics", 2, 1));
    	dexSkills.add(new Skill("Bow", 4, 1));
    	dexSkills.add(new Skill("Crossbow", 3, 1));
    	dexSkills.add(new Skill("Dodge", 5, 1));
    	dexSkills.add(new Skill("Knives", 3, 1));
    	dexSkills.add(new Skill("Lockpick", 2, 1));
    	dexSkills.add(new Skill("Pistols", 4, 1));
    	dexSkills.add(new Skill("Pickpocket", 2, 1));
    	dexSkills.add(new Skill("Ride", 2, 1));
    	dexSkills.add(new Skill("Rifles", 4, 1));
    	dexSkills.add(new Skill("Rope work", 1, 1));
    	dexSkills.add(new Skill("Sling", 2, 1));
    	dexSkills.add(new Skill("Spear", 3, 1));
    	dexSkills.add(new Skill("Stealth", 4, 1));
    	dexSkills.add(new Skill("Sword", 4, 1));
    	dexSkills.add(new Skill("Throwing Knives", 2, 1));
    	dexSkills.add(new Skill("Traps", 2, 1));
    	dexSkills.add(new Skill("Siege Weapons", 2, 1));
    	
    	mentalSkills.add(new Skill("Academics", 2, 2));
    	mentalSkills.add(new Skill("Alchemy", 5, 2));
    	mentalSkills.add(new Skill("Ancient Lang.", 2, 2));
    	mentalSkills.add(new Skill("Appraise", 3, 2));
    	mentalSkills.add(new Skill("Blacksmith", 3, 2));
    	mentalSkills.add(new Skill("Bowyer", 3, 2));
    	mentalSkills.add(new Skill("Cooking", 1, 2));
    	mentalSkills.add(new Skill("Craft", 0, 2));
    	mentalSkills.add(new Skill("FirstAid", 3, 2));
    	mentalSkills.add(new Skill("Medicine", 4, 2));
    	mentalSkills.add(new Skill("Explosives", 3, 2));
    	mentalSkills.add(new Skill("Animal Ken", 2, 2));
    	mentalSkills.add(new Skill("Herbalism", 2, 2));
    	mentalSkills.add(new Skill("Leather Working", 2, 2));
    	mentalSkills.add(new Skill("Legal Know.", 2, 2));
    	mentalSkills.add(new Skill("Magic Know.", 3, 2));
    	mentalSkills.add(new Skill("Monster Know.", 3, 2));
    	mentalSkills.add(new Skill("Navigate", 2, 2));
    	mentalSkills.add(new Skill("Observe", 4, 2));
    	mentalSkills.add(new Skill("Arcane Smith", 5, 2));
    	mentalSkills.add(new Skill("Sail", 1, 2));
    	mentalSkills.add(new Skill("Naval Tactics", 2, 2));
    	mentalSkills.add(new Skill("Species Know.", 2, 2));
    	mentalSkills.add(new Skill("Survival", 2, 2));
    	mentalSkills.add(new Skill("Tactics", 2, 2));
    	mentalSkills.add(new Skill("Torture", 2, 2));
    	mentalSkills.add(new Skill("Tracking", 2, 2));
    	mentalSkills.add(new Skill("Trade", 0, 2));
    	mentalSkills.add(new Skill("Theology", 3, 2));
    	mentalSkills.add(new Skill("Hunting", 1, 2));
    	mentalSkills.add(new Skill("Fishing", 1, 2));
    	mentalSkills.add(new Skill("Engineering", 4, 2));
    	mentalSkills.add(new Skill("Clockwork", 4, 2));
    	mentalSkills.add(new Skill("Steampunk", 4, 2));
    	
    	
    	charismaSkills.add(new Skill("Handle Animal", 2, 3));
    	charismaSkills.add(new Skill("Bluff", 2, 3));
    	charismaSkills.add(new Skill("Criminal Savvy", 1, 3));
    	charismaSkills.add(new Skill("Empathy", 2, 3));
    	charismaSkills.add(new Skill("Haggle", 4, 3));
    	charismaSkills.add(new Skill("Intimidate", 3, 3));
    	charismaSkills.add(new Skill("Merchant Savvy", 1, 3));
    	charismaSkills.add(new Skill("Persuade", 3, 3));
    	charismaSkills.add(new Skill("Pirate Savvy", 1, 3));
    	charismaSkills.add(new Skill("Polital Savvy", 1, 3));
    	charismaSkills.add(new Skill("Performance", 3, 3));
    	
    	willpowerSkills.add(new Skill("Courage", 3, 4));
    	willpowerSkills.add(new Skill("Devotion", 3, 4));
    	willpowerSkills.add(new Skill("Meditation", 2, 4));
    	willpowerSkills.add(new Skill("Resolve", 3, 4));
    	
    	Collections.sort(strengthSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(dexSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(mentalSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(charismaSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	Collections.sort(willpowerSkills, new Comparator<Skill>() {
    	    public int compare(Skill lhs, Skill rhs) {
    	        return lhs.getName().compareTo(rhs.getName());
    	    }

    	});
    	
    	
    	retList.add(strengthSkills);
    	retList.add(dexSkills);
    	retList.add(mentalSkills);
    	retList.add(charismaSkills);
    	retList.add(willpowerSkills);
    	
		return retList;
    }

    public PdfPTable getNestedAttributeTable(String txt, String label) throws DocumentException
    {
    	PdfPTable nestedAttrTable = new PdfPTable(2);
        nestedAttrTable.setWidths(new int[]{ 8, 2 } );
        
        PdfPCell cell = new PdfPCell(this.getDefaultPhrase(txt));
        cell.setBorder(Rectangle.NO_BORDER);
        nestedAttrTable.addCell(cell);
       
        cell = new PdfPCell();
        cell.setCellEvent(new AttributeTextField(label));
        cell.setBorder(Rectangle.NO_BORDER);
        nestedAttrTable.addCell(cell);
        
        return nestedAttrTable;
    }
    
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @param universe, the universe for this sheet whf or wh40k or carme
     * @param doSpellSheet, if you want to add a spellsheet to this document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createNGSCharacterSheet(String filename,  boolean doSpellSheet) throws DocumentException, IOException {
    	// step 1
        Document document = new Document();
        // step 2
        if(doSpellSheet)
        {
        	filename = filename + "AndSpell";
        }
        PdfWriter.getInstance(document, new FileOutputStream(filename + "Sheet.pdf"));
     
        // step 3
        document.open();
        // step 4
        
        String titleString = "";
        
        
        Paragraph title = new Paragraph(titleString, FontFactory.getFont(FontFactory.TIMES, 25, Font.BOLD, new BaseColor(0, 0, 0)));
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(2f);
        document.add(title);
        
        PdfPTable playerInfoTable = new PdfPTable(7);
        playerInfoTable.setWidths(new float[]{ 2, 2, 1, 1, 1, 1, 1});
        playerInfoTable.setWidthPercentage(100);
        
        PdfPCell cell = new PdfPCell(this.getDefaultPhrase("Player: __________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Name: __________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Class: ___"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Age: ___"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Height: __"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Weight: __"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Exp: __"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.setSpacingAfter(3f);
        
        document.add(playerInfoTable);
        
        PdfPTable attributeTable = new PdfPTable(7);
        attributeTable.setWidths(new int[]{ 3, 3, 3, 3, 3, 3, 3 });
        attributeTable.setWidthPercentage(105);
        //row 1
        
        /*attributeTable.addCell(this.getNestedAttributeTable("Strength:", "ATR_str"));
        attributeTable.addCell(this.getNestedAttributeTable("Dexterity:", "ATR_dex"));
        attributeTable.addCell(this.getNestedAttributeTable("Intelligence:", "ATR_int"));
        attributeTable.addCell(this.getNestedAttributeTable("Willpower:", "ATR_will"));
        attributeTable.addCell(this.getNestedAttributeTable("Charisma:", "ATR_cha"));
        attributeTable.addCell(this.getNestedAttributeTable("Protagonism:", "ATR_pro"));
        attributeTable.addCell(this.getDefaultPhrase("Init:"));
        */
        attributeTable.addCell(this.getDefaultPhrase("Strength:"));
        attributeTable.addCell(this.getDefaultPhrase("Agility:"));
        attributeTable.addCell(this.getDefaultPhrase("Intelligence:"));
        attributeTable.addCell(this.getDefaultPhrase("Willpower:"));
        attributeTable.addCell(this.getDefaultPhrase("Charisma:"));
        attributeTable.addCell(this.getDefaultPhrase("Fight:"));
        attributeTable.addCell(this.getDefaultPhrase("Magic:"));
        //row 2
        attributeTable.addCell(this.getDefaultPhrase("Platnum:"));
    	attributeTable.addCell(this.getDefaultPhrase("Gold:"));
        attributeTable.addCell(this.getDefaultPhrase("Silver:"));
        attributeTable.addCell(this.getDefaultPhrase("Copper:"));
        

        attributeTable.addCell(this.getDefaultPhrase("HP:"));
        attributeTable.addCell(this.getDefaultPhrase("WP:"));
        attributeTable.addCell(this.getDefaultPhrase("Move:"));
        
        
        //row 3
        

        attributeTable.addCell(this.getDefaultPhrase("Base Attk:"));
        attributeTable.addCell(this.getDefaultPhrase("Base Init:"));
        attributeTable.addCell(this.getDefaultPhrase("Insanity:"));
        attributeTable.addCell(this.getDefaultPhrase("Mutation:"));
        
        attributeTable.addCell(this.getDefaultPhrase("Nature"));
        attributeTable.addCell(this.getDefaultPhrase("Morality"));
        attributeTable.addCell(this.getDefaultPhrase("Spot:"));
        
        //row 4
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase(""));
       
    	attributeTable.addCell(this.getDefaultPhrase(""));
      
        
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase("S:"));
        attributeTable.addCell(this.getDefaultPhrase("P:"));
        attributeTable.addCell(this.getDefaultPhrase("B:"));
        
        
        document.add(attributeTable);
        
        
        PdfPTable skillPointsTotalTable = new PdfPTable(2);
        skillPointsTotalTable.setWidths(new int[]{ 3, 1 });
        
        cell = new PdfPCell(this.getDefaultPhrase("XP Points Spent:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillPointsTotalTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase(""));
        cell.setBorder(Rectangle.NO_BORDER);
        skillPointsTotalTable.addCell(cell);
        
        skillPointsTotalTable.setWidthPercentage(25);
        skillPointsTotalTable.setHorizontalAlignment(Element.ALIGN_LEFT);
        skillPointsTotalTable.setSpacingAfter(10f);
        skillPointsTotalTable.setSpacingBefore(10f);
        
        document.add(skillPointsTotalTable);  
        
        PdfPTable skillTitleTable = new PdfPTable(4);
        skillTitleTable.setWidths(new int[]{ 1, 1, 1, 1 });
        skillTitleTable.setWidthPercentage(105);
        
        cell = new PdfPCell(this.getDefaultPhrase("Str and Fight Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Agility Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Mental Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Charisma Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        document.add(skillTitleTable);
        
        PdfPTable skillsTable = new PdfPTable(4);
        skillsTable.setWidths(new int[]{ 1, 1, 1, 1 });
        skillsTable.setWidthPercentage(105);
        
        ArrayList<ArrayList<NCSSkill>> skillLists = null;
        

    	skillLists = getNCSSkills();

        
        ArrayList<NCSSkill> strengthSkills = skillLists.get(0);
    	ArrayList<NCSSkill> dexSkills = skillLists.get(1);
    	ArrayList<NCSSkill> mentalSkills = skillLists.get(2);
    	ArrayList<NCSSkill> charismaSkills = skillLists.get(3);
    	ArrayList<NCSSkill> willpowerSkills = skillLists.get(4);
        
        for(int i=1; i<40; i++)
        {	
        	if(!strengthSkills.isEmpty())
        	{
        		cell = new PdfPCell(this.getDefaultPhrase(strengthSkills.get(0).toString()));
        		strengthSkills.remove(0);
        	}
        	else
        	{
        		cell = new PdfPCell(this.getDefaultPhrase("\n"));
        	}
            
            skillsTable.addCell(cell);
            
            if(!dexSkills.isEmpty())
        	{
        		cell = new PdfPCell(this.getDefaultPhrase(dexSkills.get(0).toString()));
        		dexSkills.remove(0);
        	}
        	else
        	{
        		cell = new PdfPCell(this.getDefaultPhrase("\n"));
        	}
            
            skillsTable.addCell(cell);
            
            if(!mentalSkills.isEmpty())
        	{
        		cell = new PdfPCell(this.getDefaultPhrase(mentalSkills.get(0).toString()));
        		mentalSkills.remove(0);
        	}
        	else
        	{
        		cell = new PdfPCell(this.getDefaultPhrase("\n"));
        	}
            
            skillsTable.addCell(cell);
            
            
            if(i == 19)
            {
            	cell = new PdfPCell(this.getDefaultPhrase("Will and Magic Skills:"));
            }
            else if( i<19 )
            {
            	if(!charismaSkills.isEmpty())
            	{
            		cell = new PdfPCell(this.getDefaultPhrase(charismaSkills.get(0).toString()));
            		charismaSkills.remove(0);
            	}
            	else
            	{
            		cell = new PdfPCell(this.getDefaultPhrase("\n"));
            	}
            }
            else
            {
            	if(!willpowerSkills.isEmpty())
            	{
            		cell = new PdfPCell(this.getDefaultPhrase(willpowerSkills.get(0).toString()));
            		willpowerSkills.remove(0);
            	}
            	else
            	{
            		cell = new PdfPCell(this.getDefaultPhrase("\n"));
            	}
            }
            
            
            skillsTable.addCell(cell);
        	
        }
        
        document.add(skillsTable);
        
        document.newPage();
        
        PdfPTable meleeWeaponsTable = new PdfPTable(7);
        meleeWeaponsTable.setWidths(new float[]{ 3, 1f, 1f, 1f, 1f, 1f, 4.25f });
        meleeWeaponsTable.setWidthPercentage(105);
        
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Melee Weapons"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Dmg."));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Reach"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("C Rnge"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("C Mult."));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Size"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Notes:"));
        
        //fill table
        for(int i = 0; i<4*8; i++)
        {
        	meleeWeaponsTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        
        document.add(meleeWeaponsTable);
        
        PdfPTable rangedWeaponsTable = new PdfPTable(7);
        
        rangedWeaponsTable.setWidths(new float[]{ 3, 1f, 1f, 1f, 1f, 1f, 3.5f });
        rangedWeaponsTable.setWidthPercentage(105);
        
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Ranged Weapons"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Dmg."));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Range"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Relod"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("C Rnge"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("C Mult"));
        
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Notes:"));
        
        //fill table
        for(int i = 0; i<4*7; i++)
        {
        	rangedWeaponsTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(rangedWeaponsTable);
        /*
        PdfPTable explosivesTable = new PdfPTable(6);
        explosivesTable.setWidths(new float[]{ 3, 0.75f, 0.75f, 0.75f, 0.75f, 5 });
        explosivesTable.setWidthPercentage(105);
        
        explosivesTable.addCell(this.getDefaultPhrase("Explosives"));
        explosivesTable.addCell(this.getDefaultPhrase("Dmg."));
        explosivesTable.addCell(this.getDefaultPhrase("Pen."));
        explosivesTable.addCell(this.getDefaultPhrase("AOE."));
        
        explosivesTable.addCell(this.getDefaultPhrase("Ammo"));
        explosivesTable.addCell(this.getDefaultPhrase("Notes:"));
        
        //fill table
        for(int i = 0; i<3*7; i++)
        {
        	explosivesTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(explosivesTable);
        */
        PdfPTable armourTable = new PdfPTable(5);
        
        armourTable.setWidths(new float[]{ 3, 1, 1, 1f, 4.5f});
        armourTable.setWidthPercentage(105);
        
        armourTable.addCell(this.getDefaultPhrase("Armour"));
        armourTable.addCell(this.getDefaultPhrase("S."));
        armourTable.addCell(this.getDefaultPhrase("P."));
        armourTable.addCell(this.getDefaultPhrase("B."));
        armourTable.addCell(this.getDefaultPhrase("Notes:"));
        
        for(int i = 0; i<4*5; i++)
        {
        	armourTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(armourTable);
        
        PdfPTable itemTable = new PdfPTable(2);
        itemTable.setWidths(new int[]{ 1, 1});
        itemTable.setWidthPercentage(105);
        
        itemTable.addCell(this.getDefaultPhrase("Item"));
        itemTable.addCell(this.getDefaultPhrase("Notes"));
        
        for(int i = 0; i<34*2; i++)
        {
        	itemTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(itemTable);
        
        document.newPage();
        if(doSpellSheet)
        {
	        PdfPTable spellTitleTable = new PdfPTable(1);
	        spellTitleTable.setWidths(new int[]{ 1});
	        spellTitleTable.setWidthPercentage(105);
	        
	        cell = new PdfPCell(this.getDefaultPhrase("Spells:"));
	        cell.setBorder(Rectangle.NO_BORDER);
	        spellTitleTable.addCell(cell);
	        
	        
	        document.add(spellTitleTable);
	        
	        PdfPTable spellTable = new PdfPTable(13);
	        
	        spellTable.setWidths(new float[]{ 1, 1, 3, 1, 1, 1, 1, 4, 10, 1.5f, 1.5f, 1.5f, 1.5f });
	        spellTable.setWidthPercentage(105);
	        
	        spellTable.addCell(this.getDefaultPhrase("Lore", 7));
	        spellTable.addCell(this.getDefaultPhrase("MP", 7));
	        spellTable.addCell(this.getDefaultPhrase("Spell Name", 7));
	        spellTable.addCell(this.getDefaultPhrase("Pts", 7));
	        spellTable.addCell(this.getDefaultPhrase("Rnk", 7));
	        spellTable.addCell(this.getDefaultPhrase("WP", 7));
	        spellTable.addCell(this.getDefaultPhrase("Cst #", 7));
	        spellTable.addCell(this.getDefaultPhrase("Reagents", 7));
	        spellTable.addCell(this.getDefaultPhrase("Spell Effects", 7));
	        spellTable.addCell(this.getDefaultPhrase("Dmg", 7));
	        spellTable.addCell(this.getDefaultPhrase("AOE", 7));
	        spellTable.addCell(this.getDefaultPhrase("Dur", 7));
	        spellTable.addCell(this.getDefaultPhrase("Rng", 7));
	        
	        for(int i = 0; i<45; i++)
	        {
	        	if(i%10==0)
	        	{
		        	for(int j = 0; j < 13; j++)
		        	{
		        		cell = new PdfPCell(this.getDefaultPhrase("\n", 1));
		        		cell.setBackgroundColor(BaseColor.BLACK);
		        		spellTable.addCell(cell);
		        	}
	        	}
	        	
	        	for(int j = 0; j < 13; j++)
	        	{
	        		spellTable.addCell(this.getDefaultPhrase("\n"));
	        	}
	        }
	        
	        for(int j = 0; j < 13; j++)
	    	{
	    		cell = new PdfPCell(this.getDefaultPhrase("\n", 1));
	    		cell.setBackgroundColor(BaseColor.BLACK);
	    		spellTable.addCell(cell);
	    	}
	        
	        document.add(spellTable);
	        
	        document.newPage();
        }
        
        PdfPTable meritFlawTitleTable = new PdfPTable(2);
        
        meritFlawTitleTable.setWidthPercentage(100);
        
        cell = new PdfPCell(this.getDefaultPhrase("Talents:"));
        cell.setBorder(Rectangle.NO_BORDER);
        
        meritFlawTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Flaws:"));
        cell.setBorder(Rectangle.NO_BORDER);
        meritFlawTitleTable.addCell(cell);
        
        document.add(meritFlawTitleTable);
        
        PdfPTable meritFlawTable = new PdfPTable(2);
        
        meritFlawTable.setWidthPercentage(100);
        
        for(int i = 0; i<30*2; i++)
        {
        	meritFlawTable.addCell(new Phrase("\n", FontFactory.getFont(FontFactory.HELVETICA , 20)));
        }

        document.add(meritFlawTable);
        // step 5
        document.close();

    }
    
    /**
     * Takes a PdfPTable and appends some number of blanc rows to it.
     * @param table
     * @param rows
     * @param noBorder if true, adds no boarder to the cells
     */
    public void fillTable(PdfPTable table, int rows, boolean noBorder)
    {
    	for(int i = 0; i<table.getNumberOfColumns()*rows; i++)
        {
    		PdfPCell cell = new PdfPCell(this.getDefaultPhrase(" "));
    		if (noBorder)
    		{
    			cell.setBorder(Rectangle.NO_BORDER);
    		}
    		table.addCell(cell);
        }
    	
    	return;
    }
    

    /**
     * Takes a PdfPTable and appends some number of blanc rows to it.
     * @param table
     * @param rows
     * @param noBorder if true, adds no boarder to the cells
     */
    public void fillTable(PdfPTable table, int rows)
    {
    	this.fillTable(table, rows, false);
    	return;
    }
    
    /**
     * Creates a character sheet for dave's storytelling system.
     * @param filename the path to the new PDF document
     * @param doSpellSheet, if you want to add a spellsheet to this document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createCharacterSheetStorytelling(String filename,  boolean doSpellSheet) throws DocumentException, IOException {
    	// step 1
        Document document = new Document();
        // step 2
        if(doSpellSheet)
        {
        	filename = filename + "AndSpell";
        }
        PdfWriter.getInstance(document, new FileOutputStream(filename + "Sheet.pdf"));
     
        // step 3
        document.open();
        // step 4
        
        String titleString = "";
        
        titleString = "Storytelling Character Sheet";
        		
        
        
        Paragraph title = new Paragraph(titleString, FontFactory.getFont(FontFactory.TIMES, 25, Font.BOLD, new BaseColor(0, 0, 0)));
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(2f);
        document.add(title);
        
        PdfPTable playerInfoTable = new PdfPTable(5);
        playerInfoTable.setWidths(new float[]{ 2, 2, 2, 1.25f, 1});
        playerInfoTable.setWidthPercentage(100);
        
        PdfPCell cell = new PdfPCell(this.getDefaultPhrase("Player: ____________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Name: ____________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Faction: ___________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Race: _____"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Age: _____"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Features: __________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);      
        
        cell = new PdfPCell(this.getDefaultPhrase("Motavation: ________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Morality: __________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Build: _____"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Level: ____"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        playerInfoTable.setSpacingAfter(15f);
        
        document.add(playerInfoTable);
        
        
        PdfPTable attributeTable = new PdfPTable(5);
        attributeTable.setWidths(new int[]{ 1, 1, 1, 1, 1});
        attributeTable.setWidthPercentage(105);
        //row 1
        
        attributeTable.addCell(this.getDefaultPhrase("Vigour:"));
        attributeTable.addCell(this.getDefaultPhrase("Reflex:"));
        attributeTable.addCell(this.getDefaultPhrase("Wits:"));
        attributeTable.addCell(this.getDefaultPhrase("Charisma:"));
        attributeTable.addCell(this.getDefaultPhrase("Speed (base):"));
        
        //row 2
        attributeTable.addCell(this.getDefaultPhrase("Wounds:"));
        attributeTable.addCell(this.getDefaultPhrase("Wounds Max:"));
        attributeTable.addCell(this.getDefaultPhrase("Def (melee):"));
        attributeTable.addCell(this.getDefaultPhrase("Def (ranged):"));
        attributeTable.addCell(this.getDefaultPhrase("Init (base):"));
        
        //row 3
        attributeTable.addCell(this.getDefaultPhrase("Ingots:"));
        attributeTable.addCell(this.getDefaultPhrase("Melee Atk:"));
        attributeTable.addCell(this.getDefaultPhrase("Ranged Atk:"));
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase(""));

        attributeTable.setSpacingAfter(15f);
        document.add(attributeTable);
        
        PdfPTable armourTable = new PdfPTable(6);
        
        armourTable.setWidths(new float[]{ 2.75f, 1.25f, 1.5f, 1.25f, 1.25f, 4f});
        armourTable.setWidthPercentage(105);
        
        armourTable.addCell(this.getDefaultPhrase("Armour"));
        armourTable.addCell(this.getDefaultPhrase("Def Bonus"));
        armourTable.addCell(this.getDefaultPhrase("Type."));
        armourTable.addCell(this.getDefaultPhrase("Atk Pen."));
        armourTable.addCell(this.getDefaultPhrase("Spd Pen."));
        armourTable.addCell(this.getDefaultPhrase("Notes"));
        
        this.fillTable(armourTable, 4);
        
        armourTable.setSpacingAfter(10f);
        document.add(armourTable);
        
        PdfPTable meleeWeaponsTable = new PdfPTable(6);
        meleeWeaponsTable.setWidths(new float[]{ 3, 1.5f, 0.75f, 0.75f, 0.75f, 4.25f });
        meleeWeaponsTable.setWidthPercentage(105);
        
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Weapon"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Dmg Type"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Init Mod"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Spd Pen"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Def Mod"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Notes"));
        
        this.fillTable(meleeWeaponsTable, 3, false);
        meleeWeaponsTable.setSpacingAfter(10f);
        
        document.add(meleeWeaponsTable);
        
        PdfPTable rangedWeaponsTable = new PdfPTable(6);
        
        rangedWeaponsTable.setWidths(new float[]{ 3, 1.5f, 0.75f, 0.75f, 1.5f, 3.5f });
        rangedWeaponsTable.setWidthPercentage(105);
        
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Ranged Weapon"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Dmg Type"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Range"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Rld"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Ammo/Mags"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Notes:"));
        
        this.fillTable(rangedWeaponsTable, 2);
        rangedWeaponsTable.setSpacingAfter(10f);
        
        document.add(rangedWeaponsTable);
        
        
        
        
        PdfPTable skillTitleTable = new PdfPTable(4);
        skillTitleTable.setWidths(new int[]{ 1, 1, 1, 1 });
        skillTitleTable.setWidthPercentage(105);
        
        cell = new PdfPCell(this.getDefaultPhrase("Vigour Proficiencies"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Reflex Proficiencies"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Mental Proficiencies"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Charisma Proficiencies"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        document.add(skillTitleTable);
        
        PdfPTable skillsTable = new PdfPTable(4);
        skillsTable.setWidths(new int[]{ 1, 1, 1, 1 });
        skillsTable.setWidthPercentage(105);
        
        this.fillTable(skillsTable, 5);
        skillsTable.setSpacingAfter(10f);
        
        document.add(skillsTable);
        
        PdfPTable meritTitleTable = new PdfPTable(1);
        meritTitleTable.setWidths(new int[]{ 1 });
        meritTitleTable.setWidthPercentage(105);
        
        cell = new PdfPCell(this.getDefaultPhrase("Merits"));
        cell.setBorder(Rectangle.NO_BORDER);
        meritTitleTable.addCell(cell);
        
        document.add(meritTitleTable);
        
        PdfPTable meritsTable = new PdfPTable(1);
        meritsTable.setWidths(new int[]{ 1 });
        meritsTable.setWidthPercentage(105);
        
        this.fillTable(meritsTable, 8);
              
        meritsTable.setSpacingAfter(10f);  
        document.add(meritsTable);

        PdfPTable itemTable = new PdfPTable(2);
        itemTable.setWidths(new int[]{ 1, 1});
        itemTable.setWidthPercentage(105);
        
        itemTable.addCell(this.getDefaultPhrase("Item"));
        itemTable.addCell(this.getDefaultPhrase("Notes"));
        
        this.fillTable(itemTable, 6, true);
        
        document.add(itemTable);
        
        PdfPTable calculationsTable = new PdfPTable(1);
        calculationsTable.setWidths(new int[]{ 1 });
        calculationsTable.setWidthPercentage(105);
        
        cell = new PdfPCell(this.getDefaultPhrase("Calculations:"));
        cell.setBorder(Rectangle.NO_BORDER);
        calculationsTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Wounds = 5 + Merits; Wound Max = 10 + Vigour + Merits; Initiative = Reflex + Merits + Weapon Init Mod;", 8));
        cell.setBorder(Rectangle.NO_BORDER);
        calculationsTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Base Attack = Proficiency Bonus; Base Skill Check = Proficiency Bonus + Attribute Bonus (if applicable)", 8));
        cell.setBorder(Rectangle.NO_BORDER);
        calculationsTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Speed = 15 + Merits + armour, equipment and wound penalties;", 8));
        cell.setBorder(Rectangle.NO_BORDER);
        calculationsTable.addCell(cell);
        
        document.add(calculationsTable);
        
        /*
        if(doSpellSheet)
        {
        
	        PdfPTable spellTitleTable = new PdfPTable(1);
	        spellTitleTable.setWidths(new int[]{ 1});
	        spellTitleTable.setWidthPercentage(105);
	        
	        cell = new PdfPCell(this.getDefaultPhrase("Spells:"));
	        cell.setBorder(Rectangle.NO_BORDER);
	        spellTitleTable.addCell(cell);
	        
	        document.add(spellTitleTable);
	        
	        PdfPTable spellTable = new PdfPTable(13);
	        
	        spellTable.setWidths(new float[]{ 1, 1, 3, 1, 1, 1, 1, 4, 10, 1.5f, 1.5f, 1.5f, 1.5f });
	        spellTable.setWidthPercentage(105);
	        
	        spellTable.addCell(this.getDefaultPhrase("Lore", 7));
	        spellTable.addCell(this.getDefaultPhrase("MP", 7));
	        spellTable.addCell(this.getDefaultPhrase("Spell Name", 7));
	        spellTable.addCell(this.getDefaultPhrase("Pts", 7));
	        spellTable.addCell(this.getDefaultPhrase("Rnk", 7));
	        spellTable.addCell(this.getDefaultPhrase("WP", 7));
	        spellTable.addCell(this.getDefaultPhrase("Cst #", 7));
	        spellTable.addCell(this.getDefaultPhrase("Reagents", 7));
	        spellTable.addCell(this.getDefaultPhrase("Spell Effects", 7));
	        spellTable.addCell(this.getDefaultPhrase("Dmg", 7));
	        spellTable.addCell(this.getDefaultPhrase("AOE", 7));
	        spellTable.addCell(this.getDefaultPhrase("Dur", 7));
	        spellTable.addCell(this.getDefaultPhrase("Rng", 7));
	        
	        for(int i = 0; i<45; i++)
	        {
	        	if(i%10==0)
	        	{
		        	for(int j = 0; j < 13; j++)
		        	{
		        		cell = new PdfPCell(this.getDefaultPhrase("\n", 1));
		        		cell.setBackgroundColor(BaseColor.BLACK);
		        		spellTable.addCell(cell);
		        	}
	        	}
	        	
	        	for(int j = 0; j < 13; j++)
	        	{
	        		spellTable.addCell(this.getDefaultPhrase("\n"));
	        	}
	        }
	        
	        for(int j = 0; j < 13; j++)
	    	{
	    		cell = new PdfPCell(this.getDefaultPhrase("\n", 1));
	    		cell.setBackgroundColor(BaseColor.BLACK);
	    		spellTable.addCell(cell);
	    	}
	        
	        document.add(spellTable);
	        
	        document.newPage();
	        
        }
        
        PdfPTable meritFlawTitleTable = new PdfPTable(2);
        
        meritFlawTitleTable.setWidthPercentage(100);
        
        cell = new PdfPCell(this.getDefaultPhrase("Merits:"));
        cell.setBorder(Rectangle.NO_BORDER);
        
        meritFlawTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Flaws:"));
        cell.setBorder(Rectangle.NO_BORDER);
        meritFlawTitleTable.addCell(cell);
        
        document.add(meritFlawTitleTable);
        
        PdfPTable meritFlawTable = new PdfPTable(2);
        
        meritFlawTable.setWidthPercentage(100);
        
        for(int i = 0; i<30*2; i++)
        {
        	meritFlawTable.addCell(new Phrase("\n", FontFactory.getFont(FontFactory.HELVETICA , 20)));
        }

        document.add(meritFlawTable);
        // step 5
         * 
         */
        document.close();

    }
    
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @param universe, the universe for this sheet whf or wh40k or carme
     * @param doSpellSheet, if you want to add a spellsheet to this document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createCharacterSheet(String filename, String universe, boolean doSpellSheet) throws DocumentException, IOException {
    	// step 1
        Document document = new Document();
        // step 2
        if(doSpellSheet)
        {
        	filename = filename + "AndSpell";
        }
        PdfWriter.getInstance(document, new FileOutputStream(filename + "Sheet.pdf"));
     
        // step 3
        document.open();
        // step 4
        
        String titleString = "";
        
        if(universe == "whf")
        {
        	titleString = "Warhammer Fantasy Character Sheet";
        }
        else if(universe == "wh40k")
        {
        	titleString = "Warhammer 40k Character Sheet";
        }
        else if(universe == "carme")
        {
        	titleString = "Carme Character Sheet";
        }
        
        Paragraph title = new Paragraph(titleString, FontFactory.getFont(FontFactory.TIMES, 25, Font.BOLD, new BaseColor(0, 0, 0)));
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(2f);
        document.add(title);
        
        PdfPTable playerInfoTable = new PdfPTable(6);
        playerInfoTable.setWidths(new int[]{ 2, 2, 1, 1, 1, 1});
        playerInfoTable.setWidthPercentage(100);
        
        PdfPCell cell = new PdfPCell(this.getDefaultPhrase("Player: ____________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Name: ____________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Age: _____"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Height: ___"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Weight: ___"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Exp: ____"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.setSpacingAfter(3f);
        
        document.add(playerInfoTable);
        
        PdfPTable attributeTable = new PdfPTable(7);
        attributeTable.setWidths(new int[]{ 3, 3, 3, 3, 3, 3, 3 });
        attributeTable.setWidthPercentage(105);
        //row 1
        
        /*attributeTable.addCell(this.getNestedAttributeTable("Strength:", "ATR_str"));
        attributeTable.addCell(this.getNestedAttributeTable("Dexterity:", "ATR_dex"));
        attributeTable.addCell(this.getNestedAttributeTable("Intelligence:", "ATR_int"));
        attributeTable.addCell(this.getNestedAttributeTable("Willpower:", "ATR_will"));
        attributeTable.addCell(this.getNestedAttributeTable("Charisma:", "ATR_cha"));
        attributeTable.addCell(this.getNestedAttributeTable("Protagonism:", "ATR_pro"));
        attributeTable.addCell(this.getDefaultPhrase("Init:"));
        */
        attributeTable.addCell(this.getDefaultPhrase("Strength:"));
        attributeTable.addCell(this.getDefaultPhrase("Agility:"));
        attributeTable.addCell(this.getDefaultPhrase("Intelligence:"));
        attributeTable.addCell(this.getDefaultPhrase("Willpower:"));
        attributeTable.addCell(this.getDefaultPhrase("Charisma:"));
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase("Init:"));
        
        //row 2
        attributeTable.addCell(this.getDefaultPhrase("Fate Pts:"));
        attributeTable.addCell(this.getDefaultPhrase("Insanity:"));
        if(universe == "whf" || universe == "carme")
        {
        	attributeTable.addCell(this.getDefaultPhrase("Mutation:"));
        }
        else
        {
        	attributeTable.addCell(this.getDefaultPhrase("Corruption:"));
        }
        attributeTable.addCell(this.getDefaultPhrase("HP:"));
        attributeTable.addCell(this.getDefaultPhrase("WP:"));
        attributeTable.addCell(this.getDefaultPhrase("Move:"));
        attributeTable.addCell(this.getDefaultPhrase("Dodge:"));
        
        //row 3
        
        if(universe == "whf")
        {
        	attributeTable.addCell(this.getDefaultPhrase("Gold:"));
            attributeTable.addCell(this.getDefaultPhrase("Silver:"));
            attributeTable.addCell(this.getDefaultPhrase("Copper:"));
            attributeTable.addCell(this.getDefaultPhrase("Observe:"));
        }
        else if (universe == "carme")
        {
        	attributeTable.addCell(this.getDefaultPhrase("Platnum:"));
        	attributeTable.addCell(this.getDefaultPhrase("Gold:"));
            attributeTable.addCell(this.getDefaultPhrase("Silver:"));
            attributeTable.addCell(this.getDefaultPhrase("Copper:"));
        }
        else if (universe == "wh40k")
        {
        	attributeTable.addCell(this.getDefaultPhrase("Thrones:"));
            attributeTable.addCell(this.getDefaultPhrase(""));
            attributeTable.addCell(this.getDefaultPhrase(""));
            attributeTable.addCell(this.getDefaultPhrase("Percept.:"));
        }
        
        attributeTable.addCell(this.getDefaultPhrase("Will Res:"));
        attributeTable.addCell(this.getDefaultPhrase("Toxin Res:"));
        attributeTable.addCell(this.getDefaultPhrase("Dis. Res:"));
        
        //row 4
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase(""));
        
        if (universe == "carme")
        {
        	attributeTable.addCell(this.getDefaultPhrase("Disposition:"));
        }
        else
        {
        	attributeTable.addCell(this.getDefaultPhrase(""));
        }
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase("S Res:"));
        attributeTable.addCell(this.getDefaultPhrase("P Res:"));
        attributeTable.addCell(this.getDefaultPhrase("B Res:"));
        
        document.add(attributeTable);
        
        
        PdfPTable skillPointsTotalTable = new PdfPTable(2);
        skillPointsTotalTable.setWidths(new int[]{ 3, 1 });
        
        cell = new PdfPCell(this.getDefaultPhrase("Skill Points Spent:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillPointsTotalTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase(""));
        cell.setBorder(Rectangle.NO_BORDER);
        skillPointsTotalTable.addCell(cell);
        
        skillPointsTotalTable.setWidthPercentage(25);
        skillPointsTotalTable.setHorizontalAlignment(Element.ALIGN_LEFT);
        skillPointsTotalTable.setSpacingAfter(10f);
        skillPointsTotalTable.setSpacingBefore(10f);
        
        document.add(skillPointsTotalTable);  
        
        PdfPTable skillTitleTable = new PdfPTable(4);
        skillTitleTable.setWidths(new int[]{ 1, 1, 1, 1 });
        skillTitleTable.setWidthPercentage(105);
        
        cell = new PdfPCell(this.getDefaultPhrase("Strength Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Dexterity Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Mental Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Charisma Skills:"));
        cell.setBorder(Rectangle.NO_BORDER);
        skillTitleTable.addCell(cell);
        
        document.add(skillTitleTable);
        
        PdfPTable skillsTable = new PdfPTable(4);
        skillsTable.setWidths(new int[]{ 1, 1, 1, 1 });
        skillsTable.setWidthPercentage(105);
        
        ArrayList<ArrayList<Skill>> skillLists = null;
        
        if(universe == "whf")
        {
        	skillLists = getFantasySkills();
        }
        else if(universe == "wh40k")
        {
        	skillLists = get40kSkills();
        }
        else if(universe == "carme")
        {
        	skillLists = this.getCarimeSkills();
        }
        
        ArrayList<Skill> strengthSkills = skillLists.get(0);
    	ArrayList<Skill> dexSkills = skillLists.get(1);
    	ArrayList<Skill> mentalSkills = skillLists.get(2);
    	ArrayList<Skill> charismaSkills = skillLists.get(3);
    	ArrayList<Skill> willpowerSkills = skillLists.get(4);
        
        for(int i=1; i<40; i++)
        {	
        	if(!strengthSkills.isEmpty())
        	{
        		cell = new PdfPCell(this.getDefaultPhrase(strengthSkills.get(0).toString()));
        		strengthSkills.remove(0);
        	}
        	else
        	{
        		cell = new PdfPCell(this.getDefaultPhrase("\n"));
        	}
            
            skillsTable.addCell(cell);
            
            if(!dexSkills.isEmpty())
        	{
        		cell = new PdfPCell(this.getDefaultPhrase(dexSkills.get(0).toString()));
        		dexSkills.remove(0);
        	}
        	else
        	{
        		cell = new PdfPCell(this.getDefaultPhrase("\n"));
        	}
            
            skillsTable.addCell(cell);
            
            if(!mentalSkills.isEmpty())
        	{
        		cell = new PdfPCell(this.getDefaultPhrase(mentalSkills.get(0).toString()));
        		mentalSkills.remove(0);
        	}
        	else
        	{
        		cell = new PdfPCell(this.getDefaultPhrase("\n"));
        	}
            
            skillsTable.addCell(cell);
            
            if(!charismaSkills.isEmpty())
        	{
        		cell = new PdfPCell(this.getDefaultPhrase(charismaSkills.get(0).toString()));
        		charismaSkills.remove(0);
        	}
        	else
        	{
        		cell = new PdfPCell(this.getDefaultPhrase("\n"));
        	}
            
            /*
            if(i != 19)
            {
            	cell = new PdfPCell(this.getDefaultPhrase("Willpower Skills:"));
            }
            else if( i<19 )
            {
            	if(!charismaSkills.isEmpty())
            	{
            		cell = new PdfPCell(this.getDefaultPhrase(charismaSkills.get(0).toString()));
            		charismaSkills.remove(0);
            	}
            	else
            	{
            		cell = new PdfPCell(this.getDefaultPhrase("\n"));
            	}
            }
            else
            {
            	if(!willpowerSkills.isEmpty())
            	{
            		cell = new PdfPCell(this.getDefaultPhrase(willpowerSkills.get(0).toString()));
            		willpowerSkills.remove(0);
            	}
            	else
            	{
            		cell = new PdfPCell(this.getDefaultPhrase("\n"));
            	}
            }*/
            
            
            skillsTable.addCell(cell);
        	
        }
        
        document.add(skillsTable);
        
        document.newPage();
        
        PdfPTable meleeWeaponsTable = new PdfPTable(6);
        meleeWeaponsTable.setWidths(new float[]{ 3, 1.5f, 0.75f, 0.75f, 0.75f, 4.25f });
        meleeWeaponsTable.setWidthPercentage(105);
        
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Melee Weapons"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Dmg."));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Crit"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Reach"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Recov"));
        meleeWeaponsTable.addCell(this.getDefaultPhrase("Notes:"));
        
        //fill table
        for(int i = 0; i<4*8; i++)
        {
        	meleeWeaponsTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        
        document.add(meleeWeaponsTable);
        
        PdfPTable rangedWeaponsTable = new PdfPTable(6);
        
        rangedWeaponsTable.setWidths(new float[]{ 3, 1.5f, 0.75f, 0.75f, 1.5f, 3.5f });
        rangedWeaponsTable.setWidthPercentage(105);
        
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Ranged Weapons"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Dmg."));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Range"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Rld"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Ammo/Mags"));
        rangedWeaponsTable.addCell(this.getDefaultPhrase("Notes:"));
        
        //fill table
        for(int i = 0; i<4*7; i++)
        {
        	rangedWeaponsTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(rangedWeaponsTable);
        
        PdfPTable explosivesTable = new PdfPTable(5);
        explosivesTable.setWidths(new float[]{ 3, 1.5f, 0.75f, 0.75f, 5 });
        explosivesTable.setWidthPercentage(105);
        
        explosivesTable.addCell(this.getDefaultPhrase("Explosives"));
        explosivesTable.addCell(this.getDefaultPhrase("Dmg."));
        explosivesTable.addCell(this.getDefaultPhrase("AOE."));
        
        explosivesTable.addCell(this.getDefaultPhrase("Ammo"));
        explosivesTable.addCell(this.getDefaultPhrase("Notes:"));
        
        //fill table
        for(int i = 0; i<3*7; i++)
        {
        	explosivesTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(explosivesTable);
        
        PdfPTable armourTable = new PdfPTable(5);
        
        armourTable.setWidths(new float[]{ 3, 1, 1, 1.5f, 4.5f});
        armourTable.setWidthPercentage(105);
        
        armourTable.addCell(this.getDefaultPhrase("Armour"));
        armourTable.addCell(this.getDefaultPhrase("S Res."));
        armourTable.addCell(this.getDefaultPhrase("P Res."));
        armourTable.addCell(this.getDefaultPhrase("B Res."));
        armourTable.addCell(this.getDefaultPhrase("Notes"));
        
        for(int i = 0; i<4*5; i++)
        {
        	armourTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(armourTable);
        
        PdfPTable itemTable = new PdfPTable(2);
        itemTable.setWidths(new int[]{ 1, 1});
        itemTable.setWidthPercentage(105);
        
        itemTable.addCell(this.getDefaultPhrase("Item"));
        itemTable.addCell(this.getDefaultPhrase("Notes"));
        
        for(int i = 0; i<28*2; i++)
        {
        	itemTable.addCell(this.getDefaultPhrase("\n"));
        }
        
        document.add(itemTable);
        
        document.newPage();
        
        if(doSpellSheet)
        {
        
	        PdfPTable spellTitleTable = new PdfPTable(1);
	        spellTitleTable.setWidths(new int[]{ 1});
	        spellTitleTable.setWidthPercentage(105);
	        
	        cell = new PdfPCell(this.getDefaultPhrase("Spells:"));
	        cell.setBorder(Rectangle.NO_BORDER);
	        spellTitleTable.addCell(cell);
	        
	        document.add(spellTitleTable);
	        
	        PdfPTable spellTable = new PdfPTable(13);
	        
	        spellTable.setWidths(new float[]{ 1, 1, 3, 1, 1, 1, 1, 4, 10, 1.5f, 1.5f, 1.5f, 1.5f });
	        spellTable.setWidthPercentage(105);
	        
	        spellTable.addCell(this.getDefaultPhrase("Lore", 7));
	        spellTable.addCell(this.getDefaultPhrase("MP", 7));
	        spellTable.addCell(this.getDefaultPhrase("Spell Name", 7));
	        spellTable.addCell(this.getDefaultPhrase("Pts", 7));
	        spellTable.addCell(this.getDefaultPhrase("Rnk", 7));
	        spellTable.addCell(this.getDefaultPhrase("WP", 7));
	        spellTable.addCell(this.getDefaultPhrase("Cst #", 7));
	        spellTable.addCell(this.getDefaultPhrase("Reagents", 7));
	        spellTable.addCell(this.getDefaultPhrase("Spell Effects", 7));
	        spellTable.addCell(this.getDefaultPhrase("Dmg", 7));
	        spellTable.addCell(this.getDefaultPhrase("AOE", 7));
	        spellTable.addCell(this.getDefaultPhrase("Dur", 7));
	        spellTable.addCell(this.getDefaultPhrase("Rng", 7));
	        
	        for(int i = 0; i<45; i++)
	        {
	        	if(i%10==0)
	        	{
		        	for(int j = 0; j < 13; j++)
		        	{
		        		cell = new PdfPCell(this.getDefaultPhrase("\n", 1));
		        		cell.setBackgroundColor(BaseColor.BLACK);
		        		spellTable.addCell(cell);
		        	}
	        	}
	        	
	        	for(int j = 0; j < 13; j++)
	        	{
	        		spellTable.addCell(this.getDefaultPhrase("\n"));
	        	}
	        }
	        
	        for(int j = 0; j < 13; j++)
	    	{
	    		cell = new PdfPCell(this.getDefaultPhrase("\n", 1));
	    		cell.setBackgroundColor(BaseColor.BLACK);
	    		spellTable.addCell(cell);
	    	}
	        
	        document.add(spellTable);
	        
	        document.newPage();
	        
        }
        
        PdfPTable meritFlawTitleTable = new PdfPTable(2);
        
        meritFlawTitleTable.setWidthPercentage(100);
        
        cell = new PdfPCell(this.getDefaultPhrase("Merits:"));
        cell.setBorder(Rectangle.NO_BORDER);
        
        meritFlawTitleTable.addCell(cell);
        
        cell = new PdfPCell(this.getDefaultPhrase("Flaws:"));
        cell.setBorder(Rectangle.NO_BORDER);
        meritFlawTitleTable.addCell(cell);
        
        document.add(meritFlawTitleTable);
        
        PdfPTable meritFlawTable = new PdfPTable(2);
        
        meritFlawTable.setWidthPercentage(100);
        
        for(int i = 0; i<30*2; i++)
        {
        	meritFlawTable.addCell(new Phrase("\n", FontFactory.getFont(FontFactory.HELVETICA , 20)));
        }

        document.add(meritFlawTable);
        // step 5
        document.close();

    }
    
    public void createNPCCharacterSheet() throws DocumentException, IOException {
    	// step 1
        Document document = new Document();
        // step 2
        
        PdfWriter.getInstance(document, new FileOutputStream("NPCCharacterSheet.pdf"));
     
        // step 3
        document.open();
        // step 4
        
        String titleString = "NPC Character Sheet";
        
        Paragraph title = new Paragraph(titleString, FontFactory.getFont(FontFactory.TIMES, 25, Font.BOLD, new BaseColor(0, 0, 0)));
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(2f);
        document.add(title);
        
        PdfPTable playerInfoTable = new PdfPTable(1);
        playerInfoTable.setWidths(new int[]{1});
        playerInfoTable.setWidthPercentage(100);
        
        PdfPCell cell = new PdfPCell(this.getDefaultPhrase("Name: ____________________"));
        cell.setBorder(Rectangle.NO_BORDER);
        playerInfoTable.addCell(cell);
        
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.addCell(this.getDefaultPhrase(""));
        playerInfoTable.setSpacingAfter(3f);
        
        document.add(playerInfoTable);
        
        PdfPTable attributeTable = new PdfPTable(7);
        attributeTable.setWidths(new int[]{ 3, 3, 3, 3, 3, 3, 3 });
        attributeTable.setWidthPercentage(105);
        //row 1
        
        /*attributeTable.addCell(this.getNestedAttributeTable("Strength:", "ATR_str"));
        attributeTable.addCell(this.getNestedAttributeTable("Dexterity:", "ATR_dex"));
        attributeTable.addCell(this.getNestedAttributeTable("Intelligence:", "ATR_int"));
        attributeTable.addCell(this.getNestedAttributeTable("Willpower:", "ATR_will"));
        attributeTable.addCell(this.getNestedAttributeTable("Charisma:", "ATR_cha"));
        attributeTable.addCell(this.getNestedAttributeTable("Protagonism:", "ATR_pro"));
        attributeTable.addCell(this.getDefaultPhrase("Init:"));
        */
        attributeTable.addCell(this.getDefaultPhrase("Strength:"));
        attributeTable.addCell(this.getDefaultPhrase("Dexterity:"));
        attributeTable.addCell(this.getDefaultPhrase("Intelligence:"));
        attributeTable.addCell(this.getDefaultPhrase("Willpower:"));
        attributeTable.addCell(this.getDefaultPhrase("Charisma:"));
        attributeTable.addCell(this.getDefaultPhrase("MP:"));
        attributeTable.addCell(this.getDefaultPhrase("Base Init:"));
        //row 2
        attributeTable.addCell(this.getDefaultPhrase("Attack:"));
        attributeTable.addCell(this.getDefaultPhrase("Dmg:"));
        attributeTable.addCell(this.getDefaultPhrase("Attacks:"));
        attributeTable.addCell(this.getDefaultPhrase("HP:"));
        attributeTable.addCell(this.getDefaultPhrase("WP:"));
        attributeTable.addCell(this.getDefaultPhrase("Move:"));
        attributeTable.addCell(this.getDefaultPhrase(""));
        
        //row 3
        
        attributeTable.addCell(this.getDefaultPhrase("Dodge:"));
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase("Will Res:"));
        attributeTable.addCell(this.getDefaultPhrase("Toxin Res:"));
        attributeTable.addCell(this.getDefaultPhrase("Dis. Res:"));
        
        //row 4
        attributeTable.addCell(this.getDefaultPhrase("Block:"));
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase(""));
        attributeTable.addCell(this.getDefaultPhrase("Observe:"));
        attributeTable.addCell(this.getDefaultPhrase("S Res:"));
        attributeTable.addCell(this.getDefaultPhrase("P Res:"));
        attributeTable.addCell(this.getDefaultPhrase("B Res:"));
        
        document.add(attributeTable);
        // step 5
        
        document.add( Chunk.NEWLINE );
        document.add(playerInfoTable);
        document.add(attributeTable);
        
        document.add( Chunk.NEWLINE );
        document.add(playerInfoTable);
        document.add(attributeTable);
        
        document.add( Chunk.NEWLINE );
        document.add(playerInfoTable);
        document.add(attributeTable);
        
        document.add( Chunk.NEWLINE );
        document.add(playerInfoTable);
        document.add(attributeTable);
        document.close();

    }
    
    /**
     * Manipulates a PDF file src with the file dest as result
     * @param src the original PDF
     * @param dest the resulting PDF
     * @throws IOException
     * @throws DocumentException
     */
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        AcroFields form = stamper.getAcroFields();
        form.setField("text_1", "Bruno Lowagie");
        form.setFieldProperty("text_2", "fflags", 0, null);
        form.setFieldProperty("text_2", "bordercolor", BaseColor.RED, null);
        form.setField("text_2", "bruno");
        form.setFieldProperty("text_3", "clrfflags", TextField.PASSWORD, null);
        form.setFieldProperty("text_3", "setflags", PdfAnnotation.FLAGS_PRINT, null);
        form.setField("text_3", "12345678", "xxxxxxxx");
        form.setFieldProperty("text_4", "textsize", new Float(12), null);
        form.regenerateField("text_4");
        stamper.close();
        reader.close();
    }

    
    /**
     * Creates and adds a text field that will be added to a cell.
     * @see com.itextpdf.text.pdf.PdfPCellEvent#cellLayout(com.itextpdf.text.pdf.PdfPCell,
     *      com.itextpdf.text.Rectangle, com.itextpdf.text.pdf.PdfContentByte[])
     */
    public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
        PdfWriter writer = canvases[0].getPdfWriter();
        TextField text = new TextField(writer, rectangle,
                String.format("text_%s", tf));
        text.setBackgroundColor(new GrayColor(0.75f));
        switch(tf) {
        case "1":
            text.setBorderStyle(PdfBorderDictionary.STYLE_BEVELED);
            text.setText("Enter your name here...");
            text.setFontSize(0);
            text.setAlignment(Element.ALIGN_CENTER);
            text.setOptions(TextField.REQUIRED);
            break;
        case "2":
            text.setMaxCharacterLength(8);
            text.setOptions(TextField.COMB);
            text.setBorderStyle(PdfBorderDictionary.STYLE_SOLID);
            text.setBorderColor(BaseColor.BLUE);
            text.setBorderWidth(2);
            break;
        case "3":
            text.setBorderStyle(PdfBorderDictionary.STYLE_INSET);
            text.setOptions(TextField.PASSWORD);
            text.setVisibility(TextField.VISIBLE_BUT_DOES_NOT_PRINT);
            break;
        case "4":
            text.setBorderStyle(PdfBorderDictionary.STYLE_DASHED);
            text.setBorderColor(BaseColor.RED);
            text.setBorderWidth(2);
            text.setFontSize(8);
            text.setText(
                "Enter the reason why you want to win a free accreditation for the Foobar Film Festival");
            text.setOptions(TextField.MULTILINE | TextField.REQUIRED);
            break;
        }
        try {
            PdfFormField field = text.getTextField();
            if (tf == "3") {
                field.setUserName("Choose a password");
            }
            writer.addAnnotation(field);
        }
        catch(IOException ioe) {
            throw new ExceptionConverter(ioe);
        }
        catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    /**
     * Main method
     * @param args no arguments needed
     * @throws IOException
     * @throws DocumentException
     */
    public static void main(String[] args) throws DocumentException, IOException {
        TextFields example = new TextFields("0");
        //example.createNGSCharacterSheet(NCS, false);
        example.createCharacterSheetStorytelling("Storytelling", false);
        //example.createCharacterSheet(WHF, "whf", false);
        //example.createCharacterSheet(WH40k, "wh40k", false);
        //example.createCharacterSheet(CARME, "carme", false);
        //example.createNPCCharacterSheet();
        //example.createPdf(RESULT1);
        //example.manipulatePdf(RESULT1, RESULT2);
        
    }
}