package com.deoudegracht.deoudegracht.dtos;

public class InstructionStepRequestDTO {

    // No-argument constructor
    public InstructionStepRequestDTO() {}

    private String instruction;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public InstructionStepRequestDTO(String instruction) {
        this.instruction = instruction;
    }
}
