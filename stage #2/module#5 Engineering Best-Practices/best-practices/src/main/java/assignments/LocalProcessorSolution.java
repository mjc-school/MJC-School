package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class LocalProcessorSolution {
    private String processorName;
    private Long period = 10000000000000L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    public LocalProcessorSolution(String processorName, Long period, StringBuilder processorVersion, Integer valueOfCheap,
                                  Scanner informationscanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessorSolution() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (String s : stringArrayList) {
            if (s != null) {
                System.out.println(s.hashCode());
            }
        }

    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        for (String s : stringList) {
            processorVersion.append(s).append(" ");
        }
        return processorName + processorVersion.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        } finally {
            informationScanner.close();
        }
    }

}
