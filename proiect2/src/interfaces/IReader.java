package interfaces;

import classes.HealthData;

import java.util.List;

public interface IReader {
    List<HealthData> readData();
}
