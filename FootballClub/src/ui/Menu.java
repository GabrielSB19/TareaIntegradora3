/*
Gabriel Suarez
A00368589
*/


package ui;
import model.*;
import java.util.*;

public class Menu{

  private static final int ADDEMPLOYEE = 1;
  private static final int REMOVEEMPLOYEE = 2;
  private static final int EXIT = 0;

  private Scanner sc = new Scanner(System.in);
  private FootballClub myClub = new FootballClub("Deportivo Cali", 1, "23/11/1912");

  public static void WelcomeToTheClub(){
    System.out.println("*******************************************");
    System.out.println("Bienvenido al club de Futbol Deportivo Cali");
    System.out.println("*******************************************");
  }

  public void showMenu(){
    System.out.println("*******************************************");
    System.out.println("Selecciona la opcion que deseas realizar");
    System.out.println("[1] Contratar un empleado al club");
    System.out.println("[2] Despedir un empleado del club");
    System.out.println("[0] Salir");
    System.out.println("*******************************************");
  }

  public int readOption(){
    int choice = sc.nextInt();
    sc.nextLine();
    return choice;
}

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
      case EXIT:
      System.exit(0);
      break;
      default:
      System.out.println("Ingresa una opcion valida");
    }
  }

  public void startProgram(){
    int option;
    do{
      showMenu();
      option = readOption();
      doOperation(option);
    } while(option != 4);
  }

  public void showDoOperationEmployee(){
    System.out.println("Selecciona el tipo de empleado que deseas crear");
    System.out.println("[1] Entrenador principal");
    System.out.println("[2] Entrenador asistente");
    System.out.println("[3] Jugador");
  }

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

  public void showDoOperationEmployeeRemove(){
    System.out.println("Selecciona el tipo de empleado que deseas despedir");
    System.out.println("[1] Entrenador principal");
    System.out.println("[2] Entrenador asistente");
    System.out.println("[3] Jugador");
  }

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

  public void selectionEmployeeRemove(){
    System.out.println("Ingresa el nombre del empleado que deseas eliminar");
    String name = sc.nextLine();
    System.out.println(myClub.removeEmployee(name));
  }

}
