import java.util.Scanner;
import java.util.InputMismatchException;

class MuhammadUmarTimberStore
{
    Scanner input = new Scanner(System.in);

class Node
{
char Zone;
int TimberId;
String TimberKind;
float Weight;
String Status;
float Height;
int Quantity;
int Price;
String cutDate;
Node next;

Node(char Zone,int TimberId,String TimberKind,float Weight,String Status,float Height,int Quantity,int Price,String cutDate)
{
this.Zone = Zone;
this.TimberId = TimberId;
this.TimberKind = TimberKind;
this.Weight = Weight;
this.Status = Status;
this.Height = Height;
this.Quantity = Quantity;
this.Price = Price;
this.cutDate = cutDate;
this.next=null;
}
}
Node head=null;


void AddTimber() {


 int id;
 System.out.println("Please Enter The Below Mentioned Values For The New Node \n");
 System.out.println("Timber Id :");

while (true) {
    try {
        id = input.nextInt();
       if (id < 1) {
            System.out.println("Id must be greater than 0. Try again:");
            continue;}
        break;} catch (InputMismatchException e) {
        System.out.println("Invalid input! Enter a valid integer:");
        input.next();
    }
}
 Node temp=head;
 while(temp!=null){
     if(temp.TimberId == id){
         System.out.println("Sorry The Timber Id Is Already Present . Kindly Enter Another \n");
         return;
     }


     temp=temp.next;
 }

 System.out.print("Zone (A,B,C,D,E) : ");
 char zone = input.next().charAt(0);

 input.nextLine();
 System.out.println("Timber Kind (oak, pine, cedar, mahogany, teak, plywood) :");
 String TimberKind=input.nextLine();
 float Weight;
 System.out.println("Timber Weight(Kg):");
while (true) {
    try {
         Weight = input.nextFloat();
        if (Weight < 0) {
            System.out.println("Weight must be positive. Try again:");
            continue;
        }
        break;
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Enter a valid number:");
        input.next();
    }
}
 input.nextLine();
 System.out.println("Status (In Stock / Sold / Reserved) :");

 String Status=input.nextLine();
 System.out.println("Timber Height(m) :");
 float Height;
while (true) {
    try {
        Height = input.nextFloat();
        if (Height < 0) {
            System.out.println("Height must be positive. Try again:");
            continue;
        }
        break;
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Enter a valid number:");
        input.next();
    }
}

 System.out.println("Timber Quantity :");
 int Quantity;

while (true) {
    try {
        Quantity = input.nextInt();
        if (Quantity < 0) {
            System.out.println("Quantity must be positive. Try again:");
            continue;
        }
        break;
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Enter a valid number:");
        input.next();
    }
}
 System.out.println("Timber Price(Rs) :");
 int Price;

while (true) {
    try {
        Price = input.nextInt();
        if (Price < 0) {
            System.out.println("Price must be positive. Try again:");
            continue;
        }
        break;
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Enter a valid number:");
        input.next();
    }
}




 input.nextLine();

 System.out.println("Cut Date");
 String cutDate=input.nextLine();

 Node newNode = new Node(zone, id, TimberKind, Weight, Status, Height, Quantity, Price, cutDate);

 newNode.next = head;
 head = newNode;
 System.out.println("Added Successfully!\n");
}

void DisplayRecordsZone() {


if(head==null){System.out.println("No Record Availaibe . Kindly Add First\n");}

else{

 char zone;
 System.out.println("Please Enter The Zone\n");
 zone = input.next().charAt(0);
 boolean found = false;
 Node temp=head;


 while(temp != null)
 {

     if(temp.Zone==zone){
         display(temp);
         found = true;
     }
     temp=temp.next;
 }
 if(!found){
     System.out.println("No Timber Record Was Found Accordimg To The Entered Zone \n");
 }}
}

void DisplayRecordsKind() {

if(head==null){System.out.println("No Record Availaibe . Kindly Add First\n");}
else{
    System.out.println("Please Enter The KInd Of Timber (oak, pine, cedar, mahogany, teak, plywood) :\n");
    input.nextLine();
    String kind = input.nextLine();
    Node temp = head;
    boolean found = false;

    while (temp != null) {
        if (temp.TimberKind.equals(kind)) {
            display(temp);
            found = true;
        }
        temp = temp.next;
    }

    if(!found){
        System.out.println("No Record Has Been Found As Per The Input Kind Of Timber\n");
    }}
}

void Analysis() {

if(head==null){System.out.println("No Record Availaibe . Kindly Add First\n");}
else{

 Node temp=head;
 while(temp!=null)
 {
     if(temp.Quantity<100){
         display(temp);
     }

     temp=temp.next;
 }}
}

void SalesUpdate() {


	if(head==null){System.out.println("No Record Availaibe . Kindly Add First\n");}
	else{
 int id;
 int q;
 Node temp=head;
 System.out.println("Please Enter The Timber Id You Want To Sell \n");
 id=input.nextInt();

 while(temp!=null)
 {
     if(temp.TimberId==id){
         System.out.println("Please Enter The quantity to be sold \n");
         q=input.nextInt();
         if(q>temp.Quantity)
         {
             System.out.println("Invalid ! Sorry The Quantity Is More Than The Quantity To Be Sold\n");
         }
         else {
             temp.Quantity = temp.Quantity - q;
             if (temp.Quantity == 0) {
                 temp.Status = "Sold";
             } else {
                 temp.Status = "In Stock";
             }
             System.out.println("THe Sale HAs been succusfully made ");
             return;
         }
     }
     temp = temp.next;
 }}
}

void DeleteTimberRecord() {


 int id;
 Node temp=head;
 Node pre=null;
 System.out.println("Please Enter The Timber Id You Want To Delete \n");
 id=input.nextInt();
 if(head==null)
 {
	 System.out.println("No Records Are Present. Kindly Add Records First \n");
	return;
 }
 while(temp!=null)
 {
     if(temp.TimberId==id)
     {
         if(pre==null){
             head=temp.next;
             System.out.printf("The Node For TimberId %d Has Been Deleted Successfully\n",id);
             return;
         }
         else{
             pre.next=temp.next;
             System.out.printf("The Node For TimberId %d Has Been Deleted Successfully\n",id);
             return;
         }
     }
     pre=temp;
     temp=temp.next;
 }
 System.out.println("The Record For The Entered Timber Id Is Not Present !\n");
}

void UpdateTimberRecord() {
 int id;

if(head==null){System.out.println("No Record Availaibe . Kindly Add First\n");

}
 Node temp=head;
 System.out.println("Please Enter The Timber Id You Want To Update \n");
 id=input.nextInt();
 while(temp!=null)
 {

     if(temp.TimberId==id){


         System.out.println("Please Enter The New Quantity\n");
         temp.Quantity=input.nextInt();

         System.out.println("Please Enter The New Price\n");
         temp.Price=input.nextInt();

         System.out.println("New Details Have Been Updated Successfully\n");
         return;
     }
     temp=temp.next;
 }

 System.out.println("Record for The Input Timber Id Wasn't Found\n");
}

void InventoryReport() {


if(head==null){System.out.println("No Record Availaibe . Kindly Add First\n");}
if(head!=null){
 Node temp=head;
 int TotalValue=0;
 float average=0;
 int Count=0;

 System.out.println("Details For All Timber Records Present In The System Is below\n");

 while(temp!=null){
     display(temp);
     System.out.println("###########################\n");
     TotalValue=TotalValue+temp.Price;
     Count++;
     temp=temp.next;
 }

 if(Count==0){
     System.out.println("no Timber Record Is Present\n");
     return;
 }
 System.out.printf("Total Records Of Timber are %d \n",Count);
 System.out.printf("Total Value Of Timber are %d \n",TotalValue);
 average=(float)TotalValue/Count;
 System.out.printf("The Average Rate Per Timber Is %f ",average);}
}

void display(Node n) {
 System.out.printf("ID: %d\n", n.TimberId);
 System.out.printf("Zone: %c\n", n.Zone);
 System.out.printf("Kind: %s\n", n.TimberKind);
 System.out.printf("Weight: %f\n", n.Weight);
 System.out.printf("Status: %s\n", n.Status);
 System.out.printf("Height: %f\n", n.Height);
 System.out.printf("Quantity: %d\n", n.Quantity);
 System.out.printf("Price: %d\n", n.Price);
 System.out.printf("Cut Date: %s\n", n.cutDate);
}

public static void main(String args[])
{
 Scanner input=new Scanner(System.in);
 System.out.println("^~^~^~^~^~- Welcome To Muhammad Umar Timber Store -^~^~^~^~^~\n");

 MuhammadUmarTimberStore TimberStore =new MuhammadUmarTimberStore();
 int choice=0;


 while(choice!=9){

 System.out.println("Kindly Follow The Following Menue \n");

 System.out.println("(1) Add a new Timber records");
 System.out.println("(2) Display all records for a given Zone");
 System.out.println("(3) Display a particular record given the Kind");
 System.out.println("(4) Analysis of record level");
 System.out.println("(5) Sales update Report");
 System.out.println("(6) Delete a particular Timber record");
 System.out.println("(7) Update a particular Timber record");
 System.out.println("(8) Generate Inventory Report");
 System.out.println("(9) Exit");

 System.out.println("Enter Choice\n");
 while (true) {
     try {
         choice = input.nextInt();
         break;
     } catch (InputMismatchException e) {
         System.out.println("Invalid choice! Enter a number (1–9):");
         input.next();
     }
}

 if(choice==1){
     System.out.println("You Chose \n(1) Add a new Timber records\n\n");
     TimberStore.AddTimber();
 }

 if(choice==2){
     System.out.println("You Chose \n(2) Display all records for a given Zone\n\n");
     TimberStore.DisplayRecordsZone();
 }

 if(choice==3){
     System.out.println("You Chose \n(3) Display a particular record given the Kind\n\n");
     TimberStore.DisplayRecordsKind();
 }

 if(choice==4){
     System.out.println("You Chose  \n(4) Analysis of record level\n\n");
     TimberStore.Analysis();
 }

 if(choice==5){
     System.out.println("You Chose \n(5) Sales update Report\n\n");
     TimberStore.SalesUpdate();
 }

 if(choice==6){
     System.out.println("You Chose \n(6) Delete a particular Timber record\n\n");
     TimberStore.DeleteTimberRecord();
 }
 if(choice==7){
     System.out.println("You Chose\n(7) Update a particular Timber record\n\n");
     TimberStore.UpdateTimberRecord();
 }
 if(choice==8){
     System.out.println("You Chose\n(8) Generate Inventory Report\n\n");
     TimberStore.InventoryReport();
 }
 if(choice==9){
     System.out.println("You Chose \n(9) Exit\n");
     System.out.println("Thanks For Choosing Muhammad Umar Timber Store\n");
 }
 if(choice>9||choice<0){
     System.out.println("The Input Is Wrong Kindly Try Again");}}}}
