package cs3560_Assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IDValidator {
  public static void main(String[] args) {
    // Collect all the IDs from the users and groups
    List<String> allIDs = getAllIDs();

    // Check if there are any duplicated IDs
    List<String> duplicatedIDs = checkForDuplicates(allIDs);
    if (!duplicatedIDs.isEmpty()) {
      // If there are duplicated IDs, the IDs are not valid
      showDialog("The following IDs are duplicated: " + String.join(", ", duplicatedIDs));
      return;
    }

    // Check if any of the IDs contain spaces
    List<String> IDsWithSpaces = checkForSpaces(allIDs);
    if (!IDsWithSpaces.isEmpty()) {
      // If there are IDs with spaces, the IDs are not valid
      showDialog("The following IDs contain spaces: " + String.join(", ", IDsWithSpaces));
      return;
    }

    // If we reach this point, the IDs are valid
    showDialog("All IDs are valid.");
  }

  // Collects all the IDs from the users and groups
  private static List<String> getAllIDs() {
    // TODO: Implement this method
    return new ArrayList<>();
  }

  // Returns an array of duplicated IDs
  private static List<String> checkForDuplicates(List<String> allIDs) {
    return allIDs.stream()
                 .filter(id -> Collections.frequency(allIDs, id) > 1)
                 .collect(Collectors.toList());
  }

  // Returns an array of IDs that contain spaces
  private static List<String> checkForSpaces(List<String> allIDs) {
    return allIDs.stream()
                 .filter(id -> id.contains(" "))
                 .collect(Collectors.toList());
  }

  // Shows a dialog or prints a message to the console to display the validation result
  private static void showDialog(String message) {
    // TODO: Implement this method
  }
}