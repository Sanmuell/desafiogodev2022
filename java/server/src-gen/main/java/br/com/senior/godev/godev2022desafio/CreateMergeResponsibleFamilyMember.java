/**
 * This is a generated file. DO NOT EDIT ANY CODE HERE, YOUR CHANGES WILL BE LOST.
 */
package br.com.senior.godev.godev2022desafio;

import br.com.senior.messaging.model.*;

/**
 * The 'createMerge' request primitive for the ResponsibleFamilyMember entity.
 */
@CommandDescription(name="createMergeResponsibleFamilyMember", kind=CommandKind.CreateMerge, requestPrimitive="createMergeResponsibleFamilyMember", responsePrimitive="createMergeResponsibleFamilyMemberResponse")
public interface CreateMergeResponsibleFamilyMember extends MessageHandler {
    
    public ResponsibleFamilyMember createMergeResponsibleFamilyMember(ResponsibleFamilyMember toCreateMerge);
    
}
