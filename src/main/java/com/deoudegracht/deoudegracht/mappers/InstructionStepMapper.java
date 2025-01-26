package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.InstructionStepRequestDTO;
import com.deoudegracht.deoudegracht.dtos.InstructionStepResponseDTO;
import com.deoudegracht.deoudegracht.models.InstructionStep;

public class InstructionStepMapper {
    public static InstructionStepResponseDTO mapInstructionStepToInstructionStepResponseDTO(InstructionStep instructionStep) {
        InstructionStepResponseDTO instructionStepResponseDTO = new InstructionStepResponseDTO();
        instructionStepResponseDTO.setId(instructionStep.getId());
        instructionStepResponseDTO.setInstruction(instructionStep.getInstruction());
        return instructionStepResponseDTO;
    }
    public static InstructionStep mapInstructionStepRequestDTOToInstructionStep(InstructionStepRequestDTO instructionStepRequestDTO) {
        InstructionStep instructionStep = new InstructionStep();
        instructionStep.setInstruction(instructionStepRequestDTO.getInstruction());
        return instructionStep;
    }
}
