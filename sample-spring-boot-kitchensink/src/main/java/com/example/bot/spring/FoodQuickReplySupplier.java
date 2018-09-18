/*
 * Copyright 2018 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.example.bot.spring;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.linecorp.bot.model.action.CameraAction;
import com.linecorp.bot.model.action.CameraRollAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;

public class FoodQuickReplySupplier implements Supplier<Message> {
    @Override
    public Message get() {
        final List<QuickReplyItem> items = Arrays.<QuickReplyItem>asList(
                QuickReplyItem.builder()
                              .action(CameraAction.withLabel("相機拍攝"))
                              .build(),
                QuickReplyItem.builder()
                              .action(CameraRollAction.withLabel("相簿上傳"))
                              .build()
        );

        final QuickReply quickReply = QuickReply.items(items);

        return TextMessage
                .builder()
                .text("請上傳食物的照片")
                .quickReply(quickReply)
                .build();
    }

    public Message get(short lang) {
        final String[] cameraText = {"相機拍攝", "Take a photo"};
        final String[] cameraRollText = {"相簿上傳", "Upload from album"};
        final String[] response = {"請上傳食物的照片", "Please upload the photo of food"};
        final List<QuickReplyItem> items = Arrays.<QuickReplyItem>asList(
                QuickReplyItem.builder()
                              .action(CameraAction.withLabel(cameraText[lang]))
                              .build(),
                QuickReplyItem.builder()
                              .action(CameraRollAction.withLabel(cameraRollText[lang]))
                              .build()
        );

        final QuickReply quickReply = QuickReply.items(items);

        return TextMessage
                .builder()
                .text(response[lang])
                .quickReply(quickReply)
                .build();
    }
}
