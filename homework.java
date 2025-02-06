public class homework {
    
        // Method to calculate average from an array of string numbers
        public static double average(String[] numbers) throws NullPointerException, NumberFormatException {
            if (numbers == null) {
                throw new NullPointerException("Input array is null");
            }
            //Declearing variables 
            double sum = 0;
            int count = 0;
            //llop for checking number
            for (String num : numbers) {
                if (num == null) {
                    throw new NullPointerException("Array contains a null element");
                }
                sum += Double.parseDouble(num); // Convert string to double
                count++;
            }
            //exception
            if (count == 0) {
                throw new ArithmeticException("Cannot calculate average of an empty array");
            }
            
            return sum / count;
        }
        //By Soham Supekar C-67
        public static void main(String[] args) {
            String[] numbers = {"10.5", "20.3", "30.2", null}; // Intentionally including null to cause exception
            //try and ctah method for exception 
            try {
                double result = average(numbers);
                System.out.println("The average is: " + result);
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }
    }
    

