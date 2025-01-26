package com.deoudegracht.deoudegracht.dtos;

public class InstructionStepRequestDTO {

    private String instruction;
    public InstructionStepRequestDTO() {}

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public InstructionStepRequestDTO(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "InstructionStepRequestDTO{" +
                "instruction='" + instruction + '\'' +
                '}';
    }
}
