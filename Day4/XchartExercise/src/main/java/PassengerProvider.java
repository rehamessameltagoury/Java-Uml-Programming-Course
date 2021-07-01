import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.data.Tuple;
import smile.io.Read;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class PassengerProvider {
    private DataFrame passengerDataFrame;
    public DataFrame readCSV(String path) {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (path, format);
            //System.out.println(df.summary ());
            df = df.select ("pclass","survived","name","sex","age");
            //System.out.println(df.summary ());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace ();
        }
        passengerDataFrame = df;
        // System.out.println (df.summary ());
        return df;
    }
    public DataFrame getPassengerDataFrame() {
        return passengerDataFrame;
    }
    public List<Passenger> getPassengerList() {
        assert passengerDataFrame != null;
        List<Passenger> passengers = new ArrayList<>();
        ListIterator<Tuple> iterator = passengerDataFrame.stream ().collect (Collectors.toList ()).listIterator ();
        while (iterator.hasNext ()) {
            Tuple t = iterator.next ();
            Passenger p = new Passenger ();
            Passenger.id += 1;
            p.passengerId = Passenger.id;
            p.setPclass ((Integer) t.get ("pclass"));
            p.setSurvived ((Integer) t.get ("survived"));
            p.setName ((String) t.get ("name"));
            p.setSex ((String) t.get ("sex"));
            p.setAge ((Double) t.get ("age"));

            passengers.add (p);
        }
        return passengers;
    }
}
