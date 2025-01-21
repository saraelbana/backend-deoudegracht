package com.deoudegracht.deoudegracht.dtos;

public class InstructionStepResponseDTO {

    // No-argument constructor
    public InstructionStepResponseDTO() {}

    private String instruction;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public InstructionStepResponseDTO(String instruction) {
        this.instruction = instruction;
    }
}
