Double convertTemperature(String option) {
    
    if(option.equals("c")) {
        String temperatureString = IO.readln("Give me the temperature to transform into Farenheit: ");
        Double temperature = Double.parseDouble(temperatureString);
        
        return ((9.0/5)*temperature)+32;
    } else if(option.equals("f")) {
        String temperatureString = IO.readln("Give me the temperature to transform into Celsius: ");
        Double temperature = Double.parseDouble(temperatureString);

        return (temperature-32)*(5.0/9);
    }

    return 0.0;

}

void main() {

    String option = IO.readln("Give me the unit of the tempearture you want to convert (C/F): \n");
    
    Double result = convertTemperature(option.toLowerCase());

    IO.println("Your convertion is: " + result);

}