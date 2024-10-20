package Client;

import java.io.ObjectOutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
//
//public class Client  {
//
//public static void main(String[] args) throws UnknownHostException, IOException {
//	Socket s= new Socket("localhost",1234); // adr ip du serveur et le port de connexion 
//	System.out.println("je suis le client");
//	InputStream is=s.getInputStream();
//	OutputStream os=s.getOutputStream();
//	System.out.println("Donner un nombre");
//	Scanner sc = new Scanner(System.in);
//    int nb=sc.nextInt();
//	os.write(nb);
//	int rep=is.read();
//	System.out.println("le factorielle de" +nb+ "soit: "+ rep);
//	
//	
//}	
//}



//
//import java.io.ObjectOutputStream;
//
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Client {
//
//    public static void main(String[] args) throws Exception {
//        Socket so = new Socket("localhost", 1234);
//        System.out.println("Je suis le client");
//
//        OutputStream os = so.getOutputStream();
//        PrintWriter pr = new PrintWriter(os, true);
//        Scanner sc = new Scanner(System.in);
//        String st=sc.next();
//        pr.println(st);
//
//        so.close();
//    }
//}
//


import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import Objet.Compte;

//public class Client {
//
//    public static void main(String[] args) throws Exception {
//        Socket so = new Socket("localhost", 1234);
//        System.out.println("Je suis le client");
//
//        OutputStream os = so.getOutputStream();
//        ObjectOutputStream oss = new ObjectOutputStream(os);
//        Compte cm = new Compte(12,123);
//        oss.writeObject(cm);
//
//        oss.close();
//    }
//}



//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//import Objet.Compte;
//
//public class Client  {
//
//public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
//	Socket s= new Socket("localhost",1234); // adr ip du serveur et le port de connexion 
//	System.out.println("je suis le client");
//	OutputStream os=s.getOutputStream();
//	ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
//	objectOutputStream.writeObject(new Compte(1234,15.5));
//	InputStream is=s.getInputStream();
//	ObjectInputStream objectInputStream = new ObjectInputStream(is);
//    Compte cm=(Compte) objectInputStream.readObject();
//	System.out.println("compte envoye est : "+ cm);
//	
//	
//	
//}	
//}







//import java.net.*;
//import java.io.*;
//
//public class Client {
//    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("localhost", 1234);
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);        
//        out.println("Bonjour");
//        String message = in.readLine();
//        System.out.println("Client : message de serveur: " + message);
//
//        in.close();
//        out.close();
//        socket.close();
//    }
//}


public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // Création d'une socket pour se connecter au serveur sur localhost et le port 1234
        Socket s = new Socket("localhost", 1234);
        System.out.println("je suis le client"); // Affichage d'un message pour indiquer que le client est en cours d'exécution

        // Flux de sortie pour envoyer des données au serveur
        OutputStream os = s.getOutputStream();
        // Création d'un ObjectOutputStream pour sérialiser les objets à envoyer
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        // Envoi d'un objet Compte (instancié avec les valeurs 1234 et 15.5) au serveur
        objectOutputStream.writeObject(new Compte(1234, 15.5));

        // Flux d'entrée pour recevoir les données du serveur
        InputStream is = s.getInputStream();
        // Création d'un ObjectInputStream pour désérialiser les objets reçus
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        // Lecture de l'objet Compte envoyé par le serveur
        Compte cm = (Compte) objectInputStream.readObject();
        // Affichage du compte reçu du serveur
        System.out.println("compte envoyé est : " + cm);

        // Fermeture de la connexion avec le serveur
        s.close();
    }
}

