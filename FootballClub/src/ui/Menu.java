/*
Gabriel Suarez
A00368589
*/


package ui;
import model.*;
import java.util.*;

public class Menu{

  /*
  Constants to execute the user's choice
  */

  private static final int ADDEMPLOYEE = 1;
  private static final int REMOVEEMPLOYEE = 2;
  private static final int ADDTEAM = 3;
  private static final int ADDEMPLOYEETOTEAM = 4;
  private static final int UPTADEDATAEMPLOYEE = 5;
  private static final int SHOWDATAEMPLOYEE = 6;
  private static final int SHOWDATATEAM = 7;
  private static final int ADDLINEUPTOTEAM = 8;
  private static final int ADDCOACHSECTOROFFICE = 9;
  private static final int ADDPLAYERDRESSINGROOM = 10;
  private static final int CALCULATEPRICEMARKET = 11;
  private static final int CALCULATELEVEL = 12;
  private static final int SHOWINFOCLUB = 13;
  private static final int SHOWPOSITIONSECTOROFFICE = 14;
  private static final int SHOWPOSITIONDRESSING = 15;
  private static final int SHOWFORMATIONINFORMAT = 16;
  private static final int EXIT = 0;

  /*
  Defining objects
  Scanner and FootballClub
  */

  private Scanner sc = new Scanner(System.in);
  private FootballClub myClub = new FootballClub("Deportivo Cali", 1, "23/11/1912");

  /**
  *Welcome to the user who will run the program. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The user has been welcomed. <br>
  */

  public static void welcomeToTheClub(){
    System.out.println("*******************************************");
    System.out.println("Bienvenido al club de Futbol Deportivo Cali");
    System.out.println("*******************************************");
  }

  /**
  *Show the available options that allow you to run the program. <br>
  *<b>pre: </b><br>
  *<b>post: </b> All options have been shown. <br>
  */

  public void showMenu(){
    System.out.println("*******************************************");
    System.out.println("Selecciona la opcion que deseas realizar");
    System.out.println("[1] Contratar un empleado al club");
    System.out.println("[2] Despedir un empleado del club");
    System.out.println("[3] Agregar un equipo (Solo se podran agregar 2)");
    System.out.println("[4] Agregar empleados a un equipo");
    System.out.println("[5] Actualizar informacion de los empleados");
    System.out.println("[6] Mostrar la informacion de los empleados");
    System.out.println("[7] Mostrar informacion de los equipos");
    System.out.println("[8] Agregar alineacion a un equipo");
    System.out.println("[9] Agregar entrenadores a las oficinas");
    System.out.println("[10] Agregar jugadores a los camerinos");
    System.out.println("[11] Calcular el precio de mercado de los jugadores y entrenadores");
    System.out.println("[12] Calcular el nivel de los jugadores y entrenadores");
    System.out.println("[13] Ver la informacion del club");
    System.out.println("[14] Ver la posicion de los entrenadores en el sector de oficinas");
    System.out.println("[15] Ver la posicion de los jugadores en los camerinos");
    System.out.println("[16] Ver las alineaciones en el campo");
    System.out.println("[0] Salir");
    System.out.println("*******************************************");
  }

  /**
  *Read an integer to be used in switch. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The desired option has been selected <br>
  @return choice
  */

  public int readOption(){
    int choice = sc.nextInt();
    sc.nextLine();
    return choice;
}

  /**
  *Switch that allows to select the action to be executed. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The option to be executed has been selected. <br>
  @param choice User's option to run. choice must be an available option.
  */

  public void doOperation(int choice){
    switch (choice){
      case ADDEMPLOYEE:
      showDoOperationEmployee();
      doOperationEmployee(readOption());
      break;
      case REMOVEEMPLOYEE:
      showDoOperationEmployeeRemove();
      doOperationRemoveEmployee(readOption());
      selectionEmployeeRemove();
      break;
      case ADDTEAM:
      addNewTeam();
      break;
      case ADDEMPLOYEETOTEAM:
      doOperationAddEmployeeToTeam();
      break;
      case UPTADEDATAEMPLOYEE:
      showDoOperationEmployee();
      doOperationUptadeDataEmployee(readOption());
      break;
      case SHOWDATAEMPLOYEE:
      showOptionDataEmployee();
      doOperationShowEmployee(readOption());
      break;
      case SHOWDATATEAM:
      System.out.print(myClub.showDataTeam());
      break;
      case ADDLINEUPTOTEAM:
      addDataLineUp();
      break;
      case ADDCOACHSECTOROFFICE:
      selectTheCoachToTheOffice();
      break;
      case ADDPLAYERDRESSINGROOM:
      doOperationAddPlayerToTheDressing();
      break;
      case CALCULATEPRICEMARKET:
      calculatePriceMarket();
      break;
      case CALCULATELEVEL:
      calculateLevel();
      break;
      case SHOWINFOCLUB:
      System.out.print(myClub.showInformationClub());
      break;
      case SHOWPOSITIONSECTOROFFICE:
      System.out.print(myClub.showSectorOffice());
      break;
      case SHOWPOSITIONDRESSING:
      showTwoDressingRoom();
      break;
      case SHOWFORMATIONINFORMAT:
      selectShowLineUp();
      break;
      case EXIT:
      System.exit(0);
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
  }

  /**
  *Execute the option selected by the user. <br>
  *<b>pre: </b> An option has been selected <br>
  *<b>post: </b> The selected option was executed. <br>
  */

  public void startProgram(){
    int option;
    do{
      showMenu();
      option = readOption();
      doOperation(option);
    } while(option != 18);
  }

  /**
  *Shows the type of employees the club has. <br>
  *<b>pre: </b><br>
  *<b>post: </b> The types of employees have been shown <br>
  */

  public void showDoOperationEmployee(){
    System.out.println("Selecciona el tipo de empleado que deseas agregar");
    System.out.println("[1] Entrenador principal");
    System.out.println("[2] Entrenador asistente");
    System.out.println("[3] Jugador");
  }

  /**
  *Allows you to select which type of employee you want to add. <br>
  *<b>pre: </b> At least one method of adding employee must have been executed. <br>
  *<b>post: </b> The employee has been created. <br>
  @param choice User's option to run. choice must be an available option.
  */

  public void doOperationEmployee(int choice){
    switch(choice){
      case 1:
      addMainCoach();
      break;
      case 2:
      addAsistentCoach();
      break;
      case 3:
      addPlayer();
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }

  }

  /**
  *Allows you to select the status of an employee. <br>
  *<b>pre: </b> At least one method of adding employee must have been executed. <br>
  *<b>post: </b> The status of the employee, inactive or active. <br>
  @return status
  */

  public boolean optionStatus(){
    boolean status = false;
    System.out.println("[1] Activo");
    System.out.println("[2] Inactivo");
    int option = sc.nextInt();
    sc.nextLine();
    if(option == 1){
      status = true;
    }
    else if(option == 2){
      status = false;
    }
    return status;
  }

  /**
  *Allows you to add a head coach to the club <br>
  *<b>pre: </b> You should have selected option 1 to hire an employee. <br>
  *<b>post: </b> A head coach has been hired to the club. <br>
  */

  public void addMainCoach(){
    System.out.println("Ingresa el nombre del entrenador principal");
    String nameEm = sc.nextLine();
    System.out.println("Ingresa la identificacion del entrenador principal");
    int idEm = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa el salario del entrenador principal");
    int salary = sc.nextInt();
    sc.nextLine();
    System.out.println("Selecciona el estado del entrenador principal");
    boolean status = optionStatus();
    System.out.println("Ingresa los anios de experiencia del entrenador principal");
    int yearExperience = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa la cantidad de clubes dirigidos por el entrenador principal");
    int amountTeam = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa la cantidad de campeonatos ganados por el entrenador principal");
    int amountWinner = sc.nextInt();
    sc.nextLine();
    System.out.println(myClub.addEmployee(nameEm, idEm, salary, status, yearExperience, amountTeam, amountWinner));

  }

  /**
  *It allows you to know if an assistant coach was a professional. <br>
  *<b>pre: </b> You must have selected the option to create an assistant coach. <br>
  *<b>post: </b> The assistant coach was or was not professional<br>
  @return playerProfessional
  */

  public boolean wasProfesioanl(){
    boolean playerProfesional = false;
    System.out.println("[1] Fue jugador profesional");
    System.out.println("[2] NO fue jugador profesional");
    int option = sc.nextInt();
    sc.nextLine();
    if (option == 1){
      playerProfesional = true;
    }
    else if (option == 2){
      playerProfesional = false;
    }
    return playerProfesional;
  }

  /**
  *Allows you to determine the expertise of an assistant coach <br>
  *<b>pre: </b> You must have selected the option to create an assistant coach. <br>
  *<b>post: </b> The expertise of the assistant coach was determined. <br>
  @return newExpertise
  */

  public Expertise addExpertiseAsistentCoach(){
    System.out.println("[1] Ofensiva \n[2] Defensive \n[3] Posesiva \n[4] Jugadas de laboratorio");
    int option = sc.nextInt();
    sc.nextLine();
    Expertise newExpertise = Expertise.DEFAULT;
    switch(option){
      case 1:
      newExpertise = Expertise.OFFENSIVE;
      break;
      case 2:
      newExpertise = Expertise.DEFENSIVE;
      break;
      case 3:
      newExpertise = Expertise.POSSESSION;
      break;
      case 4:
      newExpertise = Expertise.LABORATORYPLAYS;
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
    return newExpertise;
  }

  /**
  *Allows you to add an assistant coach to the club <br>
  *<b>pre: </b> You should have selected option 1 to hire an employee. <br>
  *<b>post: </b> The assistant coach has been hired <br>
  */

  public void addAsistentCoach(){
    System.out.println("Ingresa el nombre del entrenador asistente");
    String nameEm = sc.nextLine();
    System.out.println("Ingresa la identificacion del entrenador asistente");
    int idEm = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa el salario del entrenador asistente");
    int salary = sc.nextInt();
    sc.nextLine();
    System.out.println("Selecciona el estado del entrenador asistente");
    boolean status = optionStatus();
    System.out.println("Ingresa los anios de experiencia del entrenador asistente");
    int yearExperience = sc.nextInt();
    sc.nextLine();
    System.out.println("el entrenado asistente: ");
    boolean playerProfesional = wasProfesioanl();
    System.out.println("Ingresa la expertisia del entrenador asistente");
    Expertise expertise = addExpertiseAsistentCoach();
    System.out.println(myClub.addEmployee(nameEm, idEm, salary, status, yearExperience, playerProfesional, expertise));
  }

  /**
  *Allows you to determine a player's position on the field. <br>
  *<b>pre: </b> You must have selected the option to create a player. <br>
  *<b>post: </b> The position of the player has been determined. <br>
  @return newPosition
  */

  public Position addPositionPlayer(){
    System.out.println("[1] Portero \n[2] Defensa \n[3] Volante \n[4] Delantero");
    int option = sc.nextInt();
    sc.nextLine();
    Position newPosition = Position.DEFAULT;
    switch(option){
      case 1:
      newPosition = Position.GOALKEEPER;
      break;
      case 2:
      newPosition = Position.DEFENCE;
      break;
      case 3:
      newPosition = Position.MIDFIELDER;
      break;
      case 4:
      newPosition = Position.FORWARD;
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
    return newPosition;
  }

  /**
  *Allows you to add a player to the club. <br>
  *<b>pre: </b> You should have selected option 1 to hire an employee. <br>
  *<b>post: </b> A player has been hired. <br>
  */

  public void addPlayer(){
    System.out.println("Ingresa el nombre del jugador");
    String nameEm = sc.nextLine();
    System.out.println("Ingresa la identificacion del jugador");
    int idEm = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa el salario del jugador");
    int salary = sc.nextInt();
    sc.nextLine();
    System.out.println("Selecciona el estado del jugador");
    boolean status = optionStatus();
    System.out.println("Ingresa el numero de camisa del jugador");
    int dorsal = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa la cantidad de goles que ha marcado el jugador");
    int amountGoal = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa la calificacion del jugador");
    double average = sc.nextDouble();
    sc.nextLine();
    System.out.println("Ingresa la posicion del jugador");
    Position position = addPositionPlayer();
    System.out.println(myClub.addEmployee(nameEm, idEm, salary, status, dorsal, amountGoal, average, position));
  }

  /**
  *Allows you to see the type of employees to dismiss from the club <br>
  *<b>pre: </b> You should have selected option 2 of firing an employee. <br>
  *<b>post: </b> The types of employees to be fired have been shown. <br>
  */

  public void showDoOperationEmployeeRemove(){
    System.out.println("Selecciona el tipo de empleado que deseas despedir");
    System.out.println("[1] Entrenador principal");
    System.out.println("[2] Entrenador asistente");
    System.out.println("[3] Jugador");
    System.out.println("En caso de que no existan empleados presiona la tecla Enter");
  }

  /**
  *Allows you to select the type of employee to be fired from the club. <br>
  *<b>pre: </b> At least one method of firing an employee must have been executed. <br>
  *<b>post: </b> An employee has been fired. <br>
  @param choice User's option to run. choice must be an available option.
  */

  public void doOperationRemoveEmployee(int choice){
      switch(choice){
        case 1:
        System.out.print(myClub.showNameMainCoach());
        break;
        case 2:
        System.out.print(myClub.showNameAsistenCoach());
        break;
        case 3:
        System.out.print(myClub.showNamePlayer());
        break;
        default:
        System.out.println("Ingresa una opcion validas");
      }
  }

  /**
  *Allows you to select the employee to be fired. <br>
  *<b>pre: </b> At least one method of firing an employee must have been executed. <br>
  *<b>post: </b> The selected employee has been fired. <br>
  */

  public void selectionEmployeeRemove(){
    System.out.println("Ingresa el nombre del empleado que deseas eliminar");
    String name = sc.nextLine();
    System.out.println(myClub.removeEmployee(name));
  }

  /**
  *Allows to add a new team to the club, only 2 can be added.
  *<b>pre: </b> You should have selected option 3 to add an employee. <br>
  *<b>post: </b> New equipment has been added <br>
  */

  public void addNewTeam(){
    System.out.println("Ingresa el nombre del equipo que deseas crear");
    String nameTeam = sc.nextLine();
    System.out.println(myClub.addTeam(nameTeam));
  }

  /**
  *Allows you to select the type of employee and the employee to be added to a team. <br>
  *<b>pre: </b> At least one employee of the selected employee type must be hired and have selected option 4.
  *<b>post: </b> An employee has been added to a team <br>
  */

  public void doOperationAddEmployeeToTeam(){
    System.out.println("A cual equipo le deseas agregar un empleado");
    System.out.print(myClub.showNameNewTeam());
    int index1 = sc.nextInt()-1;
    sc.nextLine();
    showDoOperationEmployee();
    int choice = sc.nextInt();
    sc.nextLine();
    switch(choice){
      case 1:
      System.out.println(myClub.addMainCoachToTheTeam(index1, addMainCoachTeam()));
      break;
      case 2:
      System.out.println(myClub.addAsistentCoachToTheTeam(index1, addAsistentCoachTeam()));
      break;
      case 3:
      System.out.println(myClub.addPlayerToTheTeam(index1, addPlayerTeam()));
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
  }

  /**
  *Allows you to select the head coach to add to a team. <br>
  *<b>pre: </b> At least one head coach and team exists, besides you can only add one per team. <br>
  *<b>post: </b> A head coach has been added to the selected team <br>
  @return index2
  */

  public int addMainCoachTeam(){
    System.out.println("Que entrendor principal deseas elegir para el equipo seleccionado");
    System.out.print(myClub.showNameOptionMainCoachTeam());
    int index2 = sc.nextInt()-1;
    return index2;
  }

  /**
  *Allows you to select an assistant coach to add to a team. <br>
  *<b>pre: </b> At least one assistant coach and team exists, besides you can only add three per team. <br>
  *<b>post: </b> An assistant coach has been added to the selected team <br>
  @return index3
  */

  public int addAsistentCoachTeam(){
    System.out.println("Que entrenador asistente deseas elegir para el equipo seleccionado");
    System.out.print(myClub.showNameOptionAsistenCoachTeam());
    int index3 = sc.nextInt()-1;
    return index3;
  }

  /**
  *Allows you to select a player to add to a team. <br>
  *<b>pre: </b> At least one player and team exists, moreover you can only add up to 25 players per team. <br>
  *<b>post: </b> The player has been added to the selected team <br>
  @return index4
  */

  public int addPlayerTeam(){
    System.out.println("Que jugador deseas elegir para el equipo seleccionado");
    System.out.print(myClub.showNameOptionPlayer());
    int index4 = sc.nextInt()-1;
    return index4;
  }

  /**
  *Allows you to select the type of employee for whom the data will be updated. <br>
  *<b>pre: </b> At least one employee exists according to the selected type, besides selecting option 5.
  *<b>post: </b> An employee's data has been updated<br>
  @param choice User's option to run. choice must be an available option.
  */

  public void doOperationUptadeDataEmployee(int choice){
    switch(choice){
      case 1:
      uptadeDataMainCoach();
      break;
      case 2:
      uptadeDataAsistenCoach();
      break;
      case 3:
      uptadeDataPlayer();
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
  }

  /**
  *It allows to update the data of the main coaches. <br>
  *<b>pre: </b> At least one head coach exists. <br>
  *<b>post: </b> The selected head coach has been updated <br>
  */

  public void uptadeDataMainCoach(){
    System.out.println("No podras actualizar el nombre ni el ID del entrenador principal");
    System.out.println("Selecciona el entrenador al cual le deseas actualizar los datos");
    System.out.print(myClub.showNameOptionMainCoachTeam());
    int index1 = sc.nextInt()-1;
    sc.nextLine();
    System.out.println("Acutaliza el salario del entrenador principal");
    int salary = sc.nextInt();
    sc.nextLine();
    System.out.println("Acutaliza el estado del entrenador principal");
    boolean status = optionStatus();
    System.out.println("Acutaliza los anios de experiencia del entrenador principal");
    int yearExperience = sc.nextInt();
    sc.nextLine();
    System.out.println("Actualiza la cantidad de clubes dirigidos por entrenador principal");
    int amountTeam = sc.nextInt();
    sc.nextLine();
    System.out.println("Actualiza los campeonatos ganados por entrenador principal");
    int amountWinner = sc.nextInt();
    sc.nextLine();
    System.out.println(myClub.uptadeDataMainCoachProcess(index1, salary, status, yearExperience, amountTeam, amountWinner));
  }

  /**
  *Allows to update the data of the assistant coaches. <br>
  *<b>pre: </b> At least one assistant coach exists. <br>
  *<b>post: </b> The assistant coach data has been updated. <br>
  */

  public void uptadeDataAsistenCoach(){
    System.out.println("No podras actualizar el nombre ni el ID del entrenador asistente");
    System.out.print(myClub.showNameOptionAsistenCoachTeam());
    int index1 = sc.nextInt()-1;
    sc.nextLine();
    System.out.println("Actualiza el salario del entrenador asistente");
    int salary = sc.nextInt();
    sc.nextLine();
    System.out.println("Actualiza el estado del entrenador asistente");
    boolean status = optionStatus();
    System.out.println("Ingresa los anios de experiencia del entrenador asistente");
    int yearExperience = sc.nextInt();
    sc.nextLine();
    System.out.println("Acutaliza la siguiente informacion del entrenador asistente: ");
    boolean playerProfesional = wasProfesioanl();
    System.out.println("Actualiza la expertisia del entrenador");
    Expertise expertise = addExpertiseAsistentCoach();
    System.out.println(myClub.uptadeDataAsistenCoachProcess(index1, salary, status, yearExperience, playerProfesional, expertise));
  }

  /**
  *Allows to update the players' data. <br>
  *<b>pre: </b> At least one assistant player exists. <br>
  *<b>post: </b> The player's data has been updated <br>
  */

  public void uptadeDataPlayer(){
    System.out.println("No podras actualizar el nombre ni el ID del jugador");
    System.out.print(myClub.showNameOptionPlayer());
    int index1 = sc.nextInt()-1;
    sc.nextLine();
    System.out.println("Actualia el salario del jugador");
    int salary = sc.nextInt();
    sc.nextLine();
    System.out.println("Actualiza el estado del jugador");
    boolean status = optionStatus();
    System.out.println("Actualiza el numero de camisa del jugador");
    int dorsal = sc.nextInt();
    sc.nextLine();
    System.out.println("Actualiza la cantidad de goles que ha marcado el jugador");
    int amountGoal = sc.nextInt();
    sc.nextLine();
    System.out.println("Actualiza la calificacion del jugador");
    double average = sc.nextDouble();
    sc.nextLine();
    System.out.println("Actualiza la posicion del jugador");
    Position position = addPositionPlayer();
    System.out.println(myClub.uptadeDataPlayerProcess(index1, salary, status, dorsal, amountGoal, average, position));
  }

  /**
  *Allows to show the information of the employees, according to the selected type. <br>
  *<b>pre: </b>At least one employee exists, in addition to selecting option 6.
  *<b>post: </b> Employees' information has been shown<br>
  @param choice User's option to run. choice must be an available option.
  */

  public void doOperationShowEmployee(int choice){
    switch(choice){
      case 1:
      System.out.print(myClub.showDataMainCoach());
      System.out.print(myClub.showDataAsistentCoach());
      System.out.print(myClub.showDataPlayer());
      break;
      case 2:
      optionShowEmployee();
      int option = sc.nextInt();
      switch(option){
        case 1:
        System.out.print(myClub.showDataMainCoach());
        break;
        case 2:
        System.out.print(myClub.showDataAsistentCoach());
        break;
        case 3:
        System.out.print(myClub.showDataPlayer());
        break;
        default:
        System.out.println("Ingresa una opcion valida");
      }
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
  }

  /**
  *Options to see the type of employee information, individual by type or group <br>
  *<b>pre: </b> Option 6 has been selected.
  *<b>post: </b> What type of data you want to see, group or individual by type. <br>
  */

  public void showOptionDataEmployee(){
    System.out.println("Que deseas ver");
    System.out.println("[1] La informacion de todos los empleados");
    System.out.println("[2] La informacion del empleado segun el tipo");
  }

  /**
  *Options to see the type of employees you want to see the information. <br>
  *<b>pre: </b> Option 2 of the method called "showOptionDataEmployee" was selected. <br>
  *<b>post: </b> Type of employees <br>
  */

  public void optionShowEmployee(){
    System.out.println("Que tipo de empleados desas ver");
    System.out.println("[1] Entrenador principal");
    System.out.println("[2] Entrenador asistente");
    System.out.println("[3] Jugador");
  }

  /**
  *It allows to determine the tactic of an alignment. <br>
  *<b>pre: </b> You must have selected the option to create an alignment, option 8.
  *<b>post: </b>The tactic of the alignment was determined. <br>
  @return newTactic
  */

  public Tactic optionTactic(){
    System.out.println("[1] Posesion \n[2] Contra ataque \n[3] Presion alta \n[4] Por defecto");
    int option = sc.nextInt();
    sc.nextLine();
    Tactic newTactic = Tactic.DEFAULT;
    switch(option){
      case 1:
      newTactic = Tactic.POSESION;
      break;
      case 2:
      newTactic = Tactic.COUNTERATTACK;
      break;
      case 3:
      newTactic = Tactic.HIGHPRESSURE;
      break;
      case 4:
      newTactic = Tactic.DEFAULT;
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
    return newTactic;
  }

  /**
  *Allows you to add an alignment to a selected team. <br>
  *<b>pre: </b> Option 8 should have been selected and a team must exister. <br>
  *<b>post: </b> An alignment has been added to the selected equipment. <br>
  */

  public void addDataLineUp(){
    System.out.println("A que equipo le deseas agregar una alineacion");
    System.out.print(myClub.showNameNewTeam());
    int index1 = sc.nextInt()-1;
    sc.nextLine();
    System.out.println("Ingresa la fecha en la que se creo la alineacion");
    String dateLineUp = sc.nextLine();
    System.out.println("Ingresa la tactica");
    Tactic tactic = optionTactic();
    System.out.println("Ingresa la formacion, recuerda el formato N-N-N");
    String formation = sc.nextLine();
    System.out.println(myClub.addLineUpToTheTeam(index1, dateLineUp, tactic, formation));
  }

  /**
  *Allows to add the trainers to the offices. <br>
  *<b>pre: </b> At least one trainer of any kind exists, in addition to selecting option 9.
  *<b>post: </b> A coach has been added to the office. <br>
  */

  public void selectTheCoachToTheOffice(){
    System.out.println("Que tipo de entrenador deseas agregar a la oficina");
    System.out.println("[1] Entrenador Principal");
    System.out.println("[2] Entrenador Asistente");
    boolean out = true;
    int index1 = sc.nextInt()-1;
    int index2 = 0;
    sc.nextLine();
    switch(index1){
      case 0:
      System.out.println("Selecciona un entrenador principal");
      System.out.print(myClub.showNameOptionMainCoachTeam());
      index2 = sc.nextInt()-1;
      sc.nextLine();
      break;
      case 1:
      System.out.println("Selecciona un entrenador asistente");
      System.out.print(myClub.showNameOptionAsistenCoachTeam());
      index2 = sc.nextInt()-1;
      break;
      default:
      System.out.println("Ingresa una opcion valida");
      out = false;
    }
    if(out){
      System.out.println(myClub.addCoachToTheSectorOffice(index1, index2));
    }
  }

  /**
  *Allows you to add a player to the dressing room according to the team he belongs to. <br>
  *<b>pre: </b> At least one player exists in a team that must also exister, option 10.
  *<b>post: </b> A player has been added to the team's dressing room <br>
  */

  public void doOperationAddPlayerToTheDressing(){
    System.out.println("Selecciona el equipo de los jugadores que deseas agregar al camerino");
    System.out.print(myClub.showNameNewTeam());
    int index1 = sc.nextInt()-1;
    System.out.print(myClub.showNameOfPlayerToTheTeam(index1));
    System.out.println("Selecciona el jugador que deseas agregar");
    int index2 = sc.nextInt()-1;
    System.out.println(myClub.addPlayerDressingRoom(index1, index2));
  }

  /**
  *It allows to calculate the market price of a main player or coach. <br>
  *<b>pre: </b> At least one head coach or player must exist, option 11.
  *<b>post: </b> The market price of the selected employee is ###. <br>
  */

  public void calculatePriceMarket(){
    int index1 = 0;
    System.out.println("A que tipo de empleado deseas calcularle el precio de mercado");
    System.out.println("[1] Entrenador Principal \n[2] Jugador");
    int option = sc.nextInt();
    sc.nextLine();
    switch(option){
      case 1:
      System.out.print("Selecciona un entrenador principal");
      System.out.print(myClub.showNameOptionMainCoachTeam());
      index1 = sc.nextInt()-1;
      sc.nextLine();
      System.out.println(myClub.newPriceMarketCoach(index1));
      break;
      case 2:
      System.out.println("Selecciona un jugador");
      System.out.print(myClub.showNameOptionPlayer());
      index1 = sc.nextInt()-1;
      sc.nextLine();
      System.out.print(myClub.newPriceMarketPlayer(index1));
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
  }

  /**
  *It allows to calculate the market level of a main player or coach. <br>
  *<b>pre: </b> At least one head coach or player must exist, option 12.
  *<b>post: </b> The market level of the selected employee is ###. <br>
  */

  public void calculateLevel(){
    int index1 = 0;
    System.out.println("A que tipo de empleado deseas calcularle el nivel");
    System.out.println("[1] Entrenador Principal \n[2] Jugador");
    int option = sc.nextInt();
    sc.nextLine();
    switch(option){
      case 1:
      System.out.print("Selecciona un entrenador principal");
      System.out.print(myClub.showNameOptionMainCoachTeam());
      index1 = sc.nextInt()-1;
      sc.nextLine();
      System.out.println(myClub.newLevelCoach(index1));
      break;
      case 2:
      System.out.println("Selecciona un jugador");
      System.out.print(myClub.showNameOptionPlayer());
      index1 = sc.nextInt()-1;
      sc.nextLine();
      System.out.print(myClub.newLevelPlayer(index1));
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
  }

  public void showTwoDressingRoom(){
    System.out.println("Cual camerino deseas ver");
    System.out.println("[1] Camerino 1 (equipo 1) \n[2] Camerino 2 (equipo 2)");
    System.out.println("Recuerda que si deseas ver los camerinos deben existir los equipos");
    int index1 = sc.nextInt()-1;
    sc.nextLine();
    System.out.print(myClub.showDressingRoom(index1));
  }

  public void selectShowLineUp(){
    System.out.println("Selecciona un equipo");
    System.out.print(myClub.showNameNewTeam());
    int index1 = sc.nextInt()-1;
    sc.nextLine();
    System.out.println("Selecciona la alineacion que deseas ver");
    System.out.print(myClub.showFormationWithOutFormat(index1));
    int index2 = sc.nextInt()-1;
    System.out.print(myClub.showFieldLineUpInTeam(index1, index2));
  }
}
