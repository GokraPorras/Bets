package dataAccess;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import configuration.ConfigXML;
import domain.Admin;
import domain.Bet;
import domain.BetContainer;
import domain.Erabiltzailea;
import domain.Event;
import domain.Langilea;
import domain.Mugimendua;
import domain.MugimenduaContainer;
import domain.QuestionContainer;
import domain.Question;
import domain.Result;
import domain.ResultContainer;
import domain.SuperBet;
import domain.SuperBetContainer;
import domain.User;
import exceptions.EndResultAlreadyExists;
import exceptions.NotEnoughMoney;
import exceptions.QuestionAlreadyExist;
import exceptions.ResultAlreadyExist;
import exceptions.SuperBetMinimumRes;
import exceptions.betMinimum;

/**
 * It implements the data access to the objectDb database
 */
public class DataAccess  {
	protected static EntityManager  db;
	protected static EntityManagerFactory emf;	

	ConfigXML c;
	

	public DataAccess(boolean initializeMode)  {

		c=ConfigXML.getInstance();

		System.out.println("Creating DataAccess instance => isDatabaseLocal: "+c.isDatabaseLocal()+" getDatabBaseOpenMode: "+c.getDataBaseOpenMode());

		String fileName=c.getDbFilename();
		if (initializeMode)
			fileName=fileName+";drop";

		if (c.isDatabaseLocal()) {
			emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("javax.persistence.jdbc.user", c.getUser());
			properties.put("javax.persistence.jdbc.password", c.getPassword());

			emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);

			db = emf.createEntityManager();
		}
	}

	public DataAccess()  {	
		new DataAccess(false);
	}


	/**
	 * This is the data access method that initializes the database with some events and questions.
	 * This method is invoked by the business logic (constructor of BLFacadeImplementation) when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	public void initializeDB(){

		db.getTransaction().begin();
		try {
			Admin Juan = new Admin("","","","Juan","Juan","","","","","","","","","");

			Admin Admin = new Admin("","","","Admin","Admin","","","","","","","","","");
			Langilea Langilea = new Langilea("","","","Langilea","Langilea","","","","","","","","","");
			Erabiltzailea Erabiltzailea = new Erabiltzailea("","","","Erabiltzailea","Erabiltzailea","","","","","","","","","");
			Erabiltzailea Mikel = new Erabiltzailea("","","","Mikel","Mikel","","","","","","","","","");


			Admin asd = new Admin("","","","asd","asd","","","","","","","","","");
			Admin a = new Admin("","","","Alvaro","1234","","","","","","","","","");
			Langilea l = new Langilea("","","","Gorka","1234","","","","","","","","","");
			Langilea Anonymous = new Langilea("","","","Anonymous","Anonymous","","","","","","","","","");
			Erabiltzailea e1 = new Erabiltzailea("","","","Igor","1234","","","","","","","","","");
			Erabiltzailea e2 = new Erabiltzailea("","","","David","1234","","","","","","","","","");

			db.persist(Admin);
			db.persist(Langilea);
			db.persist(Erabiltzailea);
			db.persist(Mikel);

			db.persist(Juan);
			db.persist(asd);
			db.persist(a);
			db.persist(l);
			db.persist(Anonymous);
			db.persist(e1);
			db.persist(e2);

			Event ev1=new Event(1, "Atletico-Athletic", newDate(2019,1,17));
			Event ev2=new Event(2, "Eibar-Barcelona", newDate(2019,1,17));
			Event ev3=new Event(3, "Getafe-Celta", newDate(2019,1,17));
			Event ev4=new Event(4, "Alavés-Deportivo", newDate(2019,1,17));
			Event ev5=new Event(5, "Español-Villareal", newDate(2019,1,17));
			Event ev6=new Event(6, "Las Palmas-Sevilla", newDate(2019,1,17));
			Event ev7=new Event(7, "Malaga-Valencia", newDate(2019,1,17));
			Event ev8=new Event(8, "Girona-Leganés", newDate(2019,1,17));
			Event ev9=new Event(9, "Real Sociedad-Levante", newDate(2019,1,17));
			Event ev10=new Event(10, "Betis-Real Madrid", newDate(2019,1,17));

			Event ev11=new Event(11, "Atletico-Athletic", newDate(2019,2,1));
			Event ev12=new Event(12, "Eibar-Barcelona", newDate(2019,2,1));
			Event ev13=new Event(13, "Getafe-Celta", newDate(2019,2,1));
			Event ev14=new Event(14, "Alavés-Deportivo", newDate(2019,2,1));
			Event ev15=new Event(15, "Español-Villareal", newDate(2019,2,1));
			Event ev16=new Event(16, "Las Palmas-Sevilla", newDate(2019,2,1));

			Event ev17=new Event(17, "Malaga-Valencia", newDate(2019,2,31));
			Event ev18=new Event(18, "Girona-Leganés", newDate(2019,2,31));
			Event ev19=new Event(19, "Real Sociedad-Levante", newDate(2019,2,31));
			Event ev20=new Event(20, "Betis-Real Madrid", newDate(2019,2,31));

			Event ev21=new Event(21, "Atletico-Athletic", newDate(2019,3,10));
			Event ev22=new Event(22, "Eibar-Barcelona", newDate(2019,3,10));
			Event ev23=new Event(23, "Getafe-Celta", newDate(2019,3,10));
			Event ev24=new Event(24, "Alavés-Deportivo", newDate(2019,3,10));
			Event ev25=new Event(25, "Español-Villareal", newDate(2019,3,10));
			Event ev26=new Event(26, "Las Palmas-Sevilla", newDate(2019,3,22));
			Event ev27=new Event(27, "Malaga-Valencia", newDate(2019,3,22));
			Event ev28=new Event(28, "Girona-Leganés", newDate(2019,3,22));
			Event ev29=new Event(29, "Real Sociedad-Levante", newDate(2019,3,22));
			Event ev30=new Event(30, "Betis-Real Madrid", newDate(2019,3,22));

			Event ev31=new Event(31, "Atletico-Athletic", newDate(2019,4,4));
			Event ev32=new Event(32, "Eibar-Barcelona", newDate(2019,4,4));
			Event ev33=new Event(33, "Getafe-Celta", newDate(2019,4,4));
			Event ev34=new Event(34, "Alavés-Deportivo", newDate(2019,4,4));
			Event ev35=new Event(35, "Español-Villareal", newDate(2019,4,4));
			Event ev36=new Event(36, "Las Palmas-Sevilla", newDate(2019,4,4));
			
			Event ev37=new Event(37, "Malaga-Valencia", newDate(2019,4,24));
			Event ev38=new Event(38, "Girona-Leganés", newDate(2019,4,24));
			Event ev39=new Event(39, "Real Sociedad-Levante", newDate(2019,4,24));
			Event ev40=new Event(40, "Betis-Real Madrid", newDate(2019,4,24));
			
			Event ev41=new Event(41, "Rafa Nadal-Roger Federer", newDate(2019,4,13));
			Event ev42=new Event(42, "100m-ko lasterketa", newDate(2019,4,9));
			Event ev43=new Event(43, "McGregor-Floyd Mayweather", newDate(2019,4,13));
			Event ev44=new Event(44, "Demoaren aurkezpena", newDate(2019,4,16));
			

			Question q1;
			Question q2;
			Question q3;
			Question q4;
			Question q5;
			Question q6;
			Question q7;
			Question q8;
			Question q9;
			Question q10;

			Question q11;
			Question q12;
			Question q13;
			Question q14;
			Question q15;
			Question q16;
			Question q17;
			Question q18;
			Question q19;
			Question q20;
			Question q21;
			Question q22;
			Question q23;
			Question q24;
			Question q25;
			Question q26;
			Question q27;

			if (Locale.getDefault().equals(new Locale("es"))) {
				q1=ev1.addQuestion("¿Quien ganará el partido?",1);
				q2=ev1.addQuestion("¿Quien meterá el primer gol?",2);
				q3=ev11.addQuestion("¿Quien ganará el partido?",1);
				q4=ev11.addQuestion("¿Cuántos goles se marcarán?",2);
				q5=ev17.addQuestion("¿Quien ganará el partido?",1);
				q6=ev17.addQuestion("¿Habrá goles en la primera parte?",2);
				q7=ev18.addQuestion("¿Quien ganará el partido?",2);
				q8=ev18.addQuestion("¿Que jugador hara la primera falta?",3);
				q9=ev21.addQuestion("¿Quien ganará el partido?",5);
				q10=ev21.addQuestion("¿Quien perdera el partido?",1);
				//
				q11=ev26.addQuestion("¿Quien ganará el partido?",3);
				q12=ev26.addQuestion("¿Quien meterá el primer gol?",2);
				q13=ev33.addQuestion("¿Quien ganará el partido?",6);
				q14=ev33.addQuestion("¿Cuántos goles se marcarán?",2);
				q15=ev35.addQuestion("¿Quien ganará el partido?",3);
				q16=ev35.addQuestion("¿Habrá goles en la primera parte?",7);
				q17=ev37.addQuestion("¿Quien ganará el partido?",9);
				q18=ev37.addQuestion("¿Que jugador hara la primera falta?",20);
				q19=ev40.addQuestion("¿Quien ganará el partido?",4);
				q20=ev40.addQuestion("¿Quien perdera el partido?",25);
				
				q21=ev41.addQuestion("¿Cuanto tiempo durara el partido?",20);
				q22=ev41.addQuestion("¿Quien ganara el partido?",10);
				q23=ev42.addQuestion("¿En que tiempo acabara la carrera el primer corredor?",20);
				q24=ev42.addQuestion("¿Quien quedara en el primer puesto?",10);			
				q25=ev43.addQuestion("¿Quien ganara?",5);
				q26=ev43.addQuestion("¿Cuantas rondas durara el combate?",10);
				q27=ev44.addQuestion("¿Cuanto tiempo durara?",2);
				
			}
			else if (Locale.getDefault().equals(new Locale("en"))) {
				q1=ev1.addQuestion("Who will win the match?",1);
				q2=ev1.addQuestion("Who will score first?",2);
				q3=ev11.addQuestion("Who will win the match?",1);
				q4=ev11.addQuestion("How many goals will be scored in the match?",2);
				q5=ev17.addQuestion("Who will win the match?",1);
				q6=ev17.addQuestion("Will there be goals in the first half?",2);
				q7=ev18.addQuestion("Who will win the match?",2);
				q8=ev18.addQuestion("Which player will make the first foul?",3);
				q9=ev21.addQuestion("Who will win the match?",5);
				q10=ev21.addQuestion("Who will lose the match?",1);
				//
				q11=ev26.addQuestion("Who will win the match?",3);
				q12=ev26.addQuestion("Who will score the first goal?",2);
				q13=ev33.addQuestion("Who will win the match?",6);
				q14=ev33.addQuestion("How many goals will be scored?",2);
				q15=ev35.addQuestion("Who will win the match?",3);
				q16=ev35.addQuestion("Will there be goals in the first half?",7);
				q17=ev37.addQuestion("Who will win the match?",9);
				q18=ev37.addQuestion("Which player will make the first foul?",20);
				q19=ev40.addQuestion("Who will win the match?",4);
				q20=ev40.addQuestion("Who will lose the match?",25);
				
				q21=ev41.addQuestion("How much time will the match finish?",20);
				q22=ev41.addQuestion("who will win the match?",10);
				q23=ev42.addQuestion("How much time will the race finish the first winner?",20);
				q24=ev42.addQuestion("Who will stay in the first place?",10);
				q25=ev43.addQuestion("Who will win?",5);
				q26=ev43.addQuestion("Hown many rounds the fight will finish?",10);
				q27=ev44.addQuestion("How much time this presentation will finsh?",2);

			}			
			else {
				q1=ev1.addQuestion("Zeinek irabaziko du partidua?",1);
				q2=ev1.addQuestion("Zeinek sartuko du lehenengo gola?",2);
				q3=ev11.addQuestion("Zeinek irabaziko du partidua?",1);
				q4=ev11.addQuestion("Zenbat gol sartuko dira?",2);
				q5=ev17.addQuestion("Zeinek irabaziko du partidua?",1);
				q6=ev17.addQuestion("Golak sartuko dira lehenengo zatian?",2);
				q7=ev18.addQuestion("Zeinek irabaziko du partidua?",2);
				q8=ev18.addQuestion("Zein jokalari egingo du lehen falta?",3);
				q9=ev21.addQuestion("Zeinek irabaziko du partidua?",5);
				q10=ev21.addQuestion("Zeinek galduko du partidua?",1);
				//
				q11=ev26.addQuestion("Zeinek irabaziko du partidua?",3);
				q12=ev26.addQuestion("Zeinek sartuko du lehenengo gola?",2);
				q13=ev33.addQuestion("Zeinek irabaziko du partidua?",6);
				q14=ev33.addQuestion("Zenbat gol sartuko dira?",2);
				q15=ev35.addQuestion("Zeinek irabaziko du partidua?",3);
				q16=ev35.addQuestion("Golak sartuko dira lehenengo zatian?",7);
				q17=ev37.addQuestion("Zeinek irabaziko du partidua?",9);
				q18=ev37.addQuestion("Zein jokalari egingo du lehen falta?",20);
				q19=ev40.addQuestion("Zeinek irabaziko du partidua?",4);
				q20=ev40.addQuestion("Zeinek galduko du partidua?",25);
				
				q21=ev41.addQuestion("Zenbat denbora iraungo du partiduak?",20);
				q22=ev41.addQuestion("Nork irabaziko du partidua?",10);	
				q23=ev42.addQuestion("Zenbat denbora egingo du lehenengo korrikalariak?",20);
				q24=ev42.addQuestion("Nor geldituko da lehenengo postuan?",10);
				q25=ev43.addQuestion("Nork irabaziko du?",5);
				q26=ev43.addQuestion("Zenbat txanda iraungo ditu borrokak?",10);
				q27=ev44.addQuestion("Zenbat denbora iraungo du demoak?",2);

			}

			Result r1 = q1.addResult("Atletico", 3);
			Result r2 = q1.addResult("Atletic", 2);
			Result r3 = q10.addResult("Athletic", 2);
			Result r4 = q11.addResult("Sevilla", 4);
			Result r5 = q12.addResult("Inork", 5);
			Result r6 = q15.addResult("Español", 2);
			Result r7 = q16.addResult("Bai", 10);
			Result r8 = q17.addResult("Malaga", 5);
			Result r9 = q19.addResult("Betis", 8);
			Result r10 = q20.addResult("Real Madrid", 8);

			//r1 = q1.addResult("Athletic", 2);
			//r2 = q9.addResult("Athletic", 3);
			r3 = q10.addResult("Atletico", 3);
			r4 = q11.addResult("Las Palmas", 3);
			r5 = q12.addResult("Zuk", 2);
			r6 = q15.addResult("Villareal", 9);
			r7 = q16.addResult("Ez", 7);
			r8 = q17.addResult("Valencia", 3);
			r9 = q19.addResult("Real Madrid", 3);
			r10 = q20.addResult("Betis", 3);
			
			Result r30 = q21.addResult("1h", 6);
			Result r31 = q21.addResult("2h", 3);
			Result r32 = q22.addResult("Rafa Nadal", 2);
			Result r33 = q22.addResult("Roger Federer", 3);
			Result r34 = q23.addResult("+10s", 2);
			Result r35 = q23.addResult("-10s", 3);
			Result r36 = q24.addResult("Usain Bolt", 2);
			Result r37 = q24.addResult("Griffith Joyner", 4);
			Result r38 = q24.addResult("Francis Obikwelu", 3);
			Result r39 = q24.addResult("Christine Arron", 3);
			Result r40 = q24.addResult("Murielle Ahoure", 3);
			Result r41 = q24.addResult("Tyson Gay", 5);
			Result r42 = q24.addResult("Yohan Blake", 2);
			Result r43 = q24.addResult("Steve Mullings", 8);
			Result r44 = q25.addResult("McGregor", 2);
			Result r45 = q25.addResult("Mayweather", 3);
			Result r46 = q25.addResult("Berdinketa", 5);
			Result r47 = q26.addResult("-6 rounds", 5);
			Result r48 = q26.addResult("+6 rounds", 8);
			Result r49 = q27.addResult("+10m", 5);
			Result r50 = q27.addResult("-10m", 2);
			
			
			

			db.persist(r1);
			db.persist(r2);
			db.persist(r3);
			db.persist(r4);
			db.persist(r5);
			db.persist(r6);
			db.persist(r7);
			db.persist(r8);
			db.persist(r9);
			db.persist(r10);
			db.persist(r30);
			db.persist(r31);
			db.persist(r32);
			db.persist(r33);
			db.persist(r34);
			db.persist(r35);
			db.persist(r36);
			db.persist(r37);
			db.persist(r38);
			db.persist(r39);
			db.persist(r40);
			db.persist(r41);
			db.persist(r42);
			db.persist(r43);
			db.persist(r44);
			db.persist(r45);
			db.persist(r46);
			db.persist(r47);
			db.persist(r48);
			db.persist(r49);
			db.persist(r50);
			

			db.persist(q1);
			db.persist(q2);
			db.persist(q3);
			db.persist(q4);
			db.persist(q5);
			db.persist(q6);
			db.persist(q7);
			db.persist(q8);
			db.persist(q9);
			db.persist(q10);
			db.persist(q11);
			db.persist(q12);
			db.persist(q13);
			db.persist(q14);
			db.persist(q15);
			db.persist(q16);
			db.persist(q17);
			db.persist(q18);
			db.persist(q19);
			db.persist(q20);
			db.persist(q21);
			db.persist(q22);
			db.persist(q23);
			db.persist(q24);
			db.persist(q25);
			db.persist(q26);
			db.persist(q27);

			db.persist(ev1);
			db.persist(ev2);
			db.persist(ev3);
			db.persist(ev4);
			db.persist(ev5);
			db.persist(ev6);
			db.persist(ev7);
			db.persist(ev8);
			db.persist(ev9);
			db.persist(ev10);
			db.persist(ev11);
			db.persist(ev12);
			db.persist(ev13);
			db.persist(ev14);
			db.persist(ev15);
			db.persist(ev16);
			db.persist(ev17);
			db.persist(ev18);
			db.persist(ev19);
			db.persist(ev20);
			db.persist(ev21);
			db.persist(ev22);
			db.persist(ev23);
			db.persist(ev24);
			db.persist(ev25);
			db.persist(ev26);
			db.persist(ev27);
			db.persist(ev28);
			db.persist(ev29);
			db.persist(ev30);
			db.persist(ev31);
			db.persist(ev32);
			db.persist(ev33);
			db.persist(ev34);
			db.persist(ev35);
			db.persist(ev36);
			db.persist(ev37);
			db.persist(ev38);
			db.persist(ev39);
			db.persist(ev40);
			db.persist(ev41);
			db.persist(ev42);
			db.persist(ev43);
			db.persist(ev44);

			Vector<Result> r =new Vector<Result>();
			r.add(r32);
			r.add(r44);
			
			Vector<Result> re =new Vector<Result>();
			re.add(r32);
			re.add(r45);
		
			
			db.getTransaction().commit();
			
			Mikel.setDiruzorroa(5000);
			superApustuaEgin(Mikel, 112, r);
			superApustuaEgin(Mikel, 33, re);
			
			
			
			
			
			System.out.println("Db initialized");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	//	----------------------------------------------------

	/**
	 * This method insert new user in database; if the user does not exist in Database
	 * 
	 * @param Izena user name
	 * @param Pasahitza user password
	 * @return true <--> user does not exists in database
	 */
	public boolean Register(boolean langileaDa, String iz,String ab1,String ab2,String erabiz,String pass,String NAN, String jd,String email,String tlf, String helb, String pstkod,String hrld, String prob,String herria) {
		db.getTransaction().begin();
		TypedQuery<User> query = db.createQuery("SELECT u FROM User u WHERE u.erabizena=?1 AND u.pasahitza=?2", User.class);
		query.setParameter(1, erabiz);
		query.setParameter(2, pass);
		List<User> users = query.getResultList();
		db.getTransaction().commit();
		if(users.isEmpty()) {
			if(langileaDa) {
				Langilea l = new Langilea(iz,ab1, ab2,erabiz,pass,NAN, jd,email,tlf, helb, pstkod,hrld, prob, herria);
				db.getTransaction().begin();
				db.persist(l);
				db.getTransaction().commit();
			}
			else {
				Erabiltzailea u = new Erabiltzailea(iz,ab1, ab2,erabiz,pass,NAN, jd,email,tlf, helb, pstkod,hrld, prob, herria);
				db.getTransaction().begin();
				db.persist(u);
				db.getTransaction().commit();

			}	
			return true;
		}
		else return false;


	}

	public boolean isRegister(String erabIzena, String Pasahitza) {
		TypedQuery<User> query = db.createQuery("SELECT u FROM User u WHERE u.erabizena=?1 AND u.pasahitza=?2", User.class);
		query.setParameter(1, erabIzena);
		query.setParameter(2, Pasahitza);
		List<User> users = query.getResultList();

		if(users.isEmpty())
			return false;
		else
			return true;
	}

	//	----------------------------------------------------

	public QuestionContainer getQuestionContainer(Question question) {
		Question qu = db.find(Question.class, question.getQuestionNumber());
		QuestionContainer QC = new QuestionContainer(qu);
		return QC;
	}

	public ResultContainer getResultContainer(Result result) {
		Result re = db.find(Result.class, result.getFeeNumber());
		ResultContainer RC = new ResultContainer(re);
		return RC;
	}

	public BetContainer getBetContainer(Bet bet) {
		Bet be = db.find(Bet.class, bet.getBetNumber());
		BetContainer BC = new BetContainer(be);
		return BC;
	}

	public SuperBetContainer getSuperBetContainer(SuperBet bet) {
		SuperBet sbe = db.find(SuperBet.class, bet.getSuperBetNumber());
		SuperBetContainer SBC = new SuperBetContainer(sbe);
		return SBC;
	}

	public MugimenduaContainer getMugimenduaContainer(Mugimendua mugimendua) {
		Mugimendua mu = db.find(Mugimendua.class, mugimendua.getMugiNumber());
		MugimenduaContainer MC = new MugimenduaContainer(mu);
		return MC;
	}

	//	----------------------------------------------------

	/**
	 * This method retrieves from the database the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	public Vector<Event> getEvents(Date date) {
		System.out.println(">> DataAccess: getEvents");
		Vector<Event> res = new Vector<Event>();	
		TypedQuery<Event> query = db.createQuery("SELECT ev FROM Event ev WHERE ev.eventDate=?1", Event.class);   
		query.setParameter(1, date);
		List<Event> events = query.getResultList();
		for (Event ev:events){
			System.out.println(ev.toString());		 
			res.add(ev);
		}
		return res;
	}

	public Vector<Question> getQuestions(Event event) {
		System.out.println(">> DataAccess: getQuestions");
		Vector<Question> qu = new Vector<Question>();
		TypedQuery<Question> query = db.createQuery("SELECT qu FROM Question qu WHERE qu.event=?1", Question.class);
		query.setParameter(1, event);
		List<Question> question = query.getResultList();
		for (Question quu:question){
			System.out.println(qu.toString());
			qu.add(quu);
		}
		return qu;
	}

	public Vector<Result> getResults(Question question) {
		System.out.println(">> DataAccess: getQuestions");
		Vector<Result> qu = new Vector<Result>();
		TypedQuery<Result> query = db.createQuery("SELECT re FROM Result re WHERE re.question=?1", Result.class);
		query.setParameter(1, question);
		List<Result> result = query.getResultList();
		for (Result quu:result){
			System.out.println(qu.toString());
			qu.add(quu);
		}
		return qu;
	}
	
	public Vector<Result> getResults(Vector<Result> res) {
		Vector<Result> results = new Vector<Result>();
		Result re;
		for (Result r : res) {
			re = db.find(Result.class, r.getFeeNumber());
			results.add(re);
		}
		return results;
	}

	public Vector<Mugimendua> getMugimenduak(String izena) {
		Erabiltzailea er = getErabiltzailea(izena);
		return er.getMugi();
	}

	public User getUser(String erab) {
		User us = db.find(User.class, erab);
		return us;
	}

	public Erabiltzailea getErabiltzailea(String erab) {
		Erabiltzailea er = db.find(Erabiltzailea.class, erab); 
		return er;
	}

	public Langilea getLangilea(String erab) {
		Langilea la = db.find(Langilea.class, erab); 
		return la;
	}

	public Admin getAdmin(String erab) {
		Admin ad = db.find(Admin.class, erab); 
		return ad;
	}
	
	public Result getResult(Result res) {
		Result result = db.find(Result.class, res);
		return result;
	}

	//	----------------------------------------------------

	public void gertaeraBatBikoiztu(Event ev, Date data) {
		Event newEvent, oldEvent;
		Question newQuestion;
		Result newResult;

		oldEvent = db.find(Event.class, ev.getEventNumber());

		db.getTransaction().begin();
		newEvent = new Event(oldEvent.getDescription(), data);

		for (Question oldQuestion : oldEvent.getQuestions()){
			newQuestion = newEvent.addQuestion(oldQuestion.getQuestion(), oldQuestion.getBetMinimum());
			for (Result oldResult : oldQuestion.getResults()){
				newResult = newQuestion.addResult(oldResult.getResult(), oldResult.getFee());
				db.persist(newResult);
			}
			db.persist(newQuestion);
		}
		db.persist(newEvent);
		db.getTransaction().commit();
	}

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
	public Question createQuestion(Event event, String question, float betMinimum) throws  QuestionAlreadyExist {
		System.out.println(">> DataAccess: createQuestion=> event= "+event+" question= "+question+" betMinimum="+betMinimum);

		Event ev = db.find(Event.class, event.getEventNumber());

		if (ev.DoesQuestionExists(question)) throw new QuestionAlreadyExist(ResourceBundle.getBundle("Etiquetas").getString("ErrorQueryAlreadyExist"));

		db.getTransaction().begin();
		Question q = ev.addQuestion(question, betMinimum);

		db.persist(ev); // db.persist(q) not required when CascadeType.PERSIST is added in questions property of Event class
		// @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
		db.getTransaction().commit();
		return q;
	}

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
	public Result createFee(Question q, String res, float fee) throws  ResultAlreadyExist {
		System.out.println(">> DataAccess: createFee=> Question= "+q+"Result= "+res+" betMinimum="+fee);

		Question qu = db.find(Question.class, q.getQuestionNumber());

		if(qu.DoesResultExists(res)) throw new ResultAlreadyExist(ResourceBundle.getBundle("Etiquetas").getString("ErrorResultAlreadyExist"));

		db.getTransaction().begin();
		Result r = qu.addResult(res,fee);

		db.persist(qu); // db.persist(q) not required when CascadeType.PERSIST is added in questions property of Event class
		// @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
		db.getTransaction().commit();
		return r;
	}

	public boolean deleteEvent(Event e) {
		boolean res = true;
		Event ev = db.find(Event.class,e.getEventNumber());
		try {
			Vector<Question> questions = ev.getQuestions();
			for(Question qu : questions)
				deleteQuestion(qu);
			db.getTransaction().begin();
			db.remove(ev);
			db.getTransaction().commit();
		}
		catch(Exception e1) {
			e1.printStackTrace();
			res = false;
		}
		return res;
	}

	public boolean deleteQuestion(Question q) {
		boolean res = true;
		Question qu = db.find(Question.class,q.getQuestionNumber());
		try {
			Vector<Result> resq = qu.getResults();
			for(int i = 0;i<resq.size();) {
				deleteResult(resq.get(i)); 
			}
			db.getTransaction().begin();
			getQuestionContainer(qu).getEvent().removeQuestion(qu);
			db.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	public boolean deleteResult(Result r) {
		//System.out.println(">> DataAccess: createFee=> Question= "+q+"Result= "+res+" betMinimum="+fee);
		boolean res = true;
		Vector<Erabiltzailea> erabs;
		Result re;
		Question q;
		try {
			re = db.find(Result.class, r.getFeeNumber());
			// kontainer bat erabiliz
			q = getResultContainer(re).getQuestion();
			erabs = re.WhatPeopleParticipate();

			db.getTransaction().begin();
			// kontainer batzuk erabiliz

			Vector<SuperBet> sbets = new Vector<SuperBet>();
			for(Erabiltzailea er: erabs) {
				sbets = er.removeSuperBetMatchResult(re);
				if (sbets != null) {
					for(SuperBet esb: sbets) {
						for(Result r1: esb.getResults()) {
							Result r2 = db.find(Result.class, r1.getFeeNumber());
							r2.removeSuperBet(esb);
						}
					}
				}
				er.removeBetMatchResult(re);
			}
			q.removeResult(re);

			db.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			res = false;
		}

		return res;
	}

	//	----------------------------------------------------

	public void addDirua(Erabiltzailea erab, float dirua) {
		Erabiltzailea erabiltzailea = db.find(Erabiltzailea.class,erab);

		float hasierakoDirua = erabiltzailea.getDiruzorroa();

		db.getTransaction().begin();
		erabiltzailea.setDiruzorroa(hasierakoDirua + dirua);
		erabiltzailea.addMugimendua(hasierakoDirua, dirua, hasierakoDirua + dirua, "SARRERA", new Date());

		db.persist(erabiltzailea);
		db.getTransaction().commit();
	}

	public void superApustuaEgin(Erabiltzailea erabiltzailea, float price, Vector<Result> results) throws NotEnoughMoney, betMinimum, SuperBetMinimumRes {
		float hasierakoDirua = erabiltzailea.getDiruzorroa();

		db.getTransaction().begin();
		SuperBet sb = erabiltzailea.addSuperBets(price, results);
		sb.addResultsBet();
		erabiltzailea.setDiruzorroa(hasierakoDirua - price);
		erabiltzailea.addMugimendua(hasierakoDirua, (price)*(-1), hasierakoDirua - price, "APUSTU-ANITZA", new Date());
		
		db.persist(erabiltzailea);
		db.getTransaction().commit();
	}

	public void apustuaEgin(Erabiltzailea erabiltzailea, float price, Result res) {
		float hasierakoDirua = erabiltzailea.getDiruzorroa();

		db.getTransaction().begin();
		Bet bet = erabiltzailea.addEBets(price, res);
		res.addBet(bet);
		erabiltzailea.setDiruzorroa(hasierakoDirua - price);
		erabiltzailea.addMugimendua(hasierakoDirua, (price)*(-1), hasierakoDirua - price, "APUSTUA", new Date());

		db.persist(erabiltzailea);
		db.getTransaction().commit();
	}

	public float getDirua(Erabiltzailea erab) {
		Erabiltzailea erabiltzailea = db.find(Erabiltzailea.class,erab);

		return (erabiltzailea.getDiruzorroa());
	}

	public float getIrabazia() {
		db.getTransaction().begin();
		TypedQuery<Mugimendua> query = db.createQuery("SELECT mo FROM Mugimendua mo",Mugimendua.class);
		List<Mugimendua> qu = query.getResultList();
		float irabazia = 0;

		for(Mugimendua mu: qu) {
			if(mu.getMota().compareTo("APUSTUA") == 0) {
				irabazia += (-1)*mu.getDiruHeina();
			}
			if(mu.getMota().compareTo("APUSTU-ANITZA") == 0) {
				irabazia += (-1)*mu.getDiruHeina();
			}
			if(mu.getMota().compareTo("ITZULKETA") == 0) {
				irabazia += (-1)*mu.getDiruHeina();
			}
			if(mu.getMota().compareTo("IRABAZIA") == 0) {
				irabazia += (-1)*mu.getDiruHeina();
			}
		}
		db.getTransaction().commit();

		return irabazia;
	}

	public void emaitzaipini(Result emaitza) throws EndResultAlreadyExists {
		// kontainer bat
		Question qu = db.find(Question.class, getResultContainer(emaitza).getQuestion());
		Result re = db.find(Result.class, emaitza);
		Vector<Erabiltzailea> erabs = qu.WhatPeopleParticipate();
		System.out.println(erabs.size());
		if (qu.getEmaitzaFinala() != null) throw new EndResultAlreadyExists(ResourceBundle.getBundle("Etiquetas").getString("EndResultAlreadyExists"));

		db.getTransaction().begin();
		qu.setEmaitzaFinala(re.getResult());

		for(Erabiltzailea er: erabs) 
			er.amIwinner(re);

		db.getTransaction().commit();

	}

	//	----------------------------------------------------

	public Vector<Erabiltzailea> getErabiltzaileak(){
		System.out.println(">> DataAccess: getUsers");
		Vector<Erabiltzailea> usersVector = new Vector<Erabiltzailea>();
		TypedQuery<Erabiltzailea> query = db.createQuery("SELECT p FROM Erabiltzailea p", Erabiltzailea.class);
		List<Erabiltzailea> users = query.getResultList();
		for (Erabiltzailea u:users){
			System.out.println(u.toString());
			usersVector.add(u);
		}
		return usersVector;
	}

	public boolean deleteErabiltzailea(String erabizena) {
		boolean res = true;
		try {
			Erabiltzailea e = db.find(Erabiltzailea.class, erabizena);
			db.getTransaction().begin();
			for (Bet b : e.getEbets())
				getBetContainer(b).getResult().removeBet(b);
			for (SuperBet sb : e.getSuperBets())
				for (Result r : sb.getResults())
					r.removeSuperBet(sb);
			db.remove(e);
			db.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}

	//	----------------------------------------------------

	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	private Date newDate(int year,int month,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day,0,0,0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
}
