package user;

import java.util.Scanner;

public class Service {
    Scanner scan = new Scanner(System.in);
    User[] users = new User[10];
    int count = 0;

    public void addUser() {


        System.out.println("enter Details of user Separated by comma");
        String input = scan.nextLine();
        System.out.println(input);

        String[] split = input.split(",");

        String name = split[0];
        int age = Integer.parseInt(split[1]);
        Gender gender = Gender.valueOf(split[2].toUpperCase());
        String address = split[3];
        String pinCode = split[4];
        String state = split[5];


        User user = new User(count, name, age, gender, pinCode, state, address);
        users[count] = user;

        System.out.println("Saved " + user.getName() + " with " + user.getId() + " id ");

        count++;
    }

    public void deleteUser() {
        int id = scan.nextInt();

        for (int i = 0; i <= users.length; i++) {

            User user2 = users[i];

//            if (user2 == null) {
//                continue;
//            }

            if (id == user2.getId()) {
                System.out.print("Deleted " + user2.getName() + " with " + user2.getId() + " id ");
                user2 = null;
                break;
//                continue;

            }

        }

    }

    public void searchUser() {


        int id = scan.nextInt();

        for(int i = 0;i < users.length;i++){

            User user3 = users[i];

            if( id == user3.getId()){
                System.out.println("Searched" + user3.getName() + " with " + user3.getId() +" id " );
            }
        }
    }

    public void modifyUser() {
        System.out.println("Enter id of user you want to modify");
        int id = scan.nextInt();

        for(int i = 0 ;i < users.length ;i++)
        {
            User user4 = users[i];


            if(id == user4.getId()){
                String options = "##########################################\n" +
                        "# 1 name\t\t\t\t\t\t#\n" +
                        "# 2 age\t\t\t\t\t\t#\n" +
                        "# 3 gender\t\t\t\t\t\t#\n" +
                        "# 4 address\t\t\t\t\t\t#\n" +
                        "# 5 pincode\t\t\t\t\t\t#\n" +
                        "# 6 state\t\t\t\t\t\t#\n" +
                        "# 0 return\t\t\t\t\t\t#\n" +
                        "##########################################\n";
                System.out.println(options);
                int op = scan.nextInt();
                if(op == 1){
                    System.out.println("Enter new name");
                    String name = scan.next();
                    user4.setName(name);
                }
                else if(op == 2){
                    System.out.println("Enter new age");
                    int age = scan.nextInt();
                    user4.setAge(age);
                }
                else if(op == 3){
                    if(user4.getGender()== Gender.M){
                        user4.setGender(Gender.F);
                    }
                    else{
                        user4.setGender(Gender.M);
                    }
                }
                else if( op == 4){
                    System.out.println("Enter new address");
                    String address = scan.next();
                    user4.setAddress(address);

                }
                else if( op == 5){
                    System.out.println("Enter new pinCode");
                    String pincode = scan.next();
                    user4.setPinCode(pincode);
                }
                else if( op ==  6){
                    System.out.println("Enter new state");
                    String state = scan.next();
                    user4.setState(state);
                }
            }

        }

    }
}
