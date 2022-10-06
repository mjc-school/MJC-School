package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;

public class LocalProcessor {
    private String processorName;
    private Long period = 10000000000000L;
    protected String ProcessorVersion;
    private Integer valueofCheap;
    Scanner informationscanner;
    LinkedList<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        ProcessorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationscanner = informationscanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listiterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorgenerator(LinkedList<String> stringList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName+=stringList.get(i)+' ';
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readfullprocessorname(File file) throws FileNotFoundException {
            informationscanner = new Scanner(file);
            while (informationscanner.hasNext()) {
                ProcessorVersion+= informationscanner.nextLine();
            }

    }

    public String getProcessorName() {
        return processorName;
    }

    public Long getperiod() {
        return period;
    }

    public String getProcessorVersion() {
        return ProcessorVersion;
    }

    public Integer getValueofCheap() {
        return valueofCheap;
    }

    public Scanner getInformationScanner() {
        return informationscanner;
    }

    public LinkedList<String> getStringArrayList() {
        return stringArrayList;
    }

    public void setProcessorName(String processorName) {

        this.processorName = processorName;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public void setProcessorVersion(String processorVersion) {
        ProcessorVersion = processorVersion;
    }

    public void setValueofCheap(Integer valueofCheap) {
        this.valueofCheap = valueofCheap;
    }

    public void setInformationscanner(Scanner informationscanner) {
        this.informationscanner = informationscanner;
    }

    public void setStringArrayList(LinkedList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }
}
