/*
 * Cerberus  Copyright (C) 2013  vertigo17
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This file is part of Cerberus.
 *
 * Cerberus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cerberus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cerberus.crud.service.impl;

import java.util.List;

import org.cerberus.crud.dao.IBuildRevisionInvariantDAO;
import org.cerberus.crud.entity.Application;
import org.cerberus.crud.entity.BuildRevisionInvariant;
import org.cerberus.crud.entity.MessageGeneral;
import org.cerberus.exception.CerberusException;
import org.cerberus.crud.service.IBuildRevisionInvariantService;
import org.cerberus.enums.MessageEventEnum;
import org.cerberus.enums.MessageGeneralEnum;
import org.cerberus.util.answer.Answer;
import org.cerberus.util.answer.AnswerItem;
import org.cerberus.util.answer.AnswerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildRevisionInvariantService implements IBuildRevisionInvariantService {

    @Autowired
    private IBuildRevisionInvariantDAO BuildRevisionInvariantDAO;

    @Override
    public AnswerItem readByKey(String system, Integer level, Integer seq) {
        return BuildRevisionInvariantDAO.readByKey(system, level, seq);
    }

    @Override
    public AnswerList readBySystemByCriteria(String system, Integer level, int start, int amount, String column, String dir, String searchTerm, String individualSearch) {
        return BuildRevisionInvariantDAO.readByVariousByCriteria(system, level, start, amount, column, dir, searchTerm, individualSearch);
    }

    @Override
    public BuildRevisionInvariant findBuildRevisionInvariantByKey(String system, Integer level, Integer seq) throws CerberusException {
        return BuildRevisionInvariantDAO.findBuildRevisionInvariantByKey(system, level, seq);
    }

    @Override
    public BuildRevisionInvariant findBuildRevisionInvariantByKey(String system, Integer level, String versionName) throws CerberusException {
        return BuildRevisionInvariantDAO.findBuildRevisionInvariantByKey(system, level, versionName);
    }

    @Override
    public List<BuildRevisionInvariant> findAllBuildRevisionInvariantBySystemLevel(String system, Integer level) throws CerberusException {
        return BuildRevisionInvariantDAO.findAllBuildRevisionInvariantBySystemLevel(system, level);
    }

    @Override
    public List<BuildRevisionInvariant> findAllBuildRevisionInvariantBySystem(String system) throws CerberusException {
        return BuildRevisionInvariantDAO.findAllBuildRevisionInvariantBySystem(system);
    }

    @Override
    public boolean insertBuildRevisionInvariant(BuildRevisionInvariant buildRevisionInvariant) {
        return BuildRevisionInvariantDAO.insertBuildRevisionInvariant(buildRevisionInvariant);
    }

    @Override
    public boolean deleteBuildRevisionInvariant(BuildRevisionInvariant buildRevisionInvariant) {
        return BuildRevisionInvariantDAO.deleteBuildRevisionInvariant(buildRevisionInvariant);
    }

    @Override
    public boolean updateBuildRevisionInvariant(BuildRevisionInvariant buildRevisionInvariant) {
        return BuildRevisionInvariantDAO.updateBuildRevisionInvariant(buildRevisionInvariant);
    }

    @Override
    public boolean exist(String system, Integer level, Integer seq) {
        try {
            convert(readByKey(system, level, seq));
            return true;
        } catch (CerberusException e) {
            return false;
        }
    }

    @Override
    public Answer create(BuildRevisionInvariant buildRevisionInvariant) {
        return BuildRevisionInvariantDAO.create(buildRevisionInvariant);
    }

    @Override
    public Answer delete(BuildRevisionInvariant buildRevisionInvariant) {
        return BuildRevisionInvariantDAO.delete(buildRevisionInvariant);
    }

    @Override
    public Answer update(BuildRevisionInvariant buildRevisionInvariant) {
        return BuildRevisionInvariantDAO.update(buildRevisionInvariant);
    }

    @Override
    public BuildRevisionInvariant convert(AnswerItem answerItem) throws CerberusException {
        if (answerItem.isCodeEquals(MessageEventEnum.DATA_OPERATION_OK.getCode())) {
            //if the service returns an OK message then we can get the item
            return (BuildRevisionInvariant) answerItem.getItem();
        }
        throw new CerberusException(new MessageGeneral(MessageGeneralEnum.DATA_OPERATION_ERROR));
    }

    @Override
    public List<BuildRevisionInvariant> convert(AnswerList answerList) throws CerberusException {
        if (answerList.isCodeEquals(MessageEventEnum.DATA_OPERATION_OK.getCode())) {
            //if the service returns an OK message then we can get the item
            return (List<BuildRevisionInvariant>) answerList.getDataList();
        }
        throw new CerberusException(new MessageGeneral(MessageGeneralEnum.DATA_OPERATION_ERROR));
    }

    @Override
    public void convert(Answer answer) throws CerberusException {
        if (answer.isCodeEquals(MessageEventEnum.DATA_OPERATION_OK.getCode())) {
            //if the service returns an OK message then we can get the item
            return;
        }
        throw new CerberusException(new MessageGeneral(MessageGeneralEnum.DATA_OPERATION_ERROR));
    }

}
