package businessLogic;

import java.util.Date;
import java.util.Vector;

import domain.Question;
import domain.Result;
import domain.ResultContainer;
import domain.SuperBet;
import domain.SuperBetContainer;
import domain.User;
import domain.Admin;
import domain.Bet;
import domain.BetContainer;
import domain.Erabiltzailea;
import domain.Event;
import domain.Langilea;
import domain.Mugimendua;
import domain.MugimenduaContainer;
import domain.QuestionContainer;
import exceptions.EndResultAlreadyExists;
import exceptions.EventFinished;
import exceptions.EventInCurrent;
import exceptions.MaximumMoneyInserted;
import exceptions.NotEnoughMoney;
import exceptions.QuestionAlreadyExist;
import exceptions.ResultAlreadyExist;
import exceptions.SuperBetMinimumRes;
import exceptions.betMinimum;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Interface that specifies the business logic.
 */
@WebService
public interface BLFacade  {

	/**
	 * This method calls the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	@WebMethod public void initializeBD();

	//	----------------------------------------------------

	/**
	 * This method insert new user in database; if the user does not exist in Database
	 * 
	 * @param Izena user name
	 * @param Pasahitza user password
	 * @return true <--> user does not exists in database
	 */
	@WebMethod public boolean Register(boolean langileaDa, String iz,String ab1,String ab2,String erabiz,String pass,String NAN, String jd,String email,String tlf, String helb, String pstkod,String hrld, String prob,String herria);

	/**
	 * This method check if user exist in Database
	 * 
	 * @param Izena user name
	 * @param Pasahitza  user password
	 * @return true <--> user exists in database
	 */
	@WebMethod public boolean isRegister(String Izena, String Pasahitza);

	//	----------------------------------------------------

	@WebMethod public QuestionContainer getQuestionContainer(Question question);

	@WebMethod public ResultContainer getResultContainer(Result result);

	@WebMethod public BetContainer getBetContainer(Bet bet);

	@WebMethod public SuperBetContainer getSuperBetContainer(SuperBet bet);

	@WebMethod public MugimenduaContainer getMugimenduaContainer(Mugimendua mugimendua);

	//	----------------------------------------------------

	/**
	 * This method retrieves the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	@WebMethod public Vector<Event> getEvents(Date date);

	@WebMethod public Vector<Question> getQuestions(Event event);

	@WebMethod public Vector<Result> getResults(Question question);

	@WebMethod public Vector<Mugimendua> getMugimenduak(String izena);

	@WebMethod public User getUser(String Izena);

	@WebMethod public Erabiltzailea getErabiltzailea(String erab);

	@WebMethod public Langilea getLangilea(String erab);

	@WebMethod public Admin getAdmin(String erab);

	//	----------------------------------------------------

	@WebMethod public void gertaeraBatBikoiztu(Event ev, Date data) throws EventFinished;

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
	@WebMethod public Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist;

	@WebMethod public Result createFee(Question q, String res, float fee) throws ResultAlreadyExist,EventFinished;

	@WebMethod public boolean deleteEvent(Event e);

	@WebMethod public boolean deleteQuestion (Question q);

	@WebMethod public boolean deleteResult(Result r);

	//	----------------------------------------------------

	@WebMethod public void addDirua(Erabiltzailea erab, float dirua) throws MaximumMoneyInserted;

	@WebMethod public void superApustuaEgin(String erab, float price, Vector<Result> res) throws NotEnoughMoney, betMinimum, EventFinished,SuperBetMinimumRes;

	@WebMethod public void apustuaEgin(String erab, float price, Result res) throws NotEnoughMoney, betMinimum, EventFinished;

	@WebMethod public float getDirua(Erabiltzailea erab);

	@WebMethod public float getIrabazia();

	@WebMethod public void emaitzaipini(Result emaitza) throws EventInCurrent, EndResultAlreadyExists;

	//	----------------------------------------------------

	@WebMethod public Vector<Erabiltzailea> getErabiltzaileak();

	@WebMethod public boolean deleteErabiltzailea(String erab);

	//	----------------------------------------------------

}
