package com.deoudegracht.deoudegracht.dtos;

public class InstructionStepResponseDTO {

    public InstructionStepResponseDTO() {}

    private String instruction;
    private long id;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public InstructionStepResponseDTO(String instruction) {
        this.instruction = instruction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
