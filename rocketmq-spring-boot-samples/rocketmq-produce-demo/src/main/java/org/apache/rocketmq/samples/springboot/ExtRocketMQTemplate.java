/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.samples.springboot;

import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * 如何声明不同name-server或者其他特定的属性来定义非标的RocketMQTemplate？
 * 第一步： 定义非标的RocketMQTemplate使用你需要的属性，注意，这里的'nameServer'属性必须要定义，并且其取值不能与全局配置属性'rocketmq.name-server'相同
 * 也可以定义其他属性，如果不定义，它们取全局的配置属性值或默认值。
 *
 * 这个RocketMQTemplate的Spring Bean名是'extRocketMQTemplate', 与所定义的类名相同(但首字母小写)
 *
 * // 第二步: 使用这个非标RocketMQTemplate
 * @Resource(name = "extRocketMQTemplate") // 这里必须定义name属性来指向上具体的Spring Bean.
 * private RocketMQTemplate extRocketMQTemplate;
 * // 接下来就可以正常使用这个extRocketMQTemplate了.
 *
 */
@ExtRocketMQTemplateConfiguration(nameServer = "${demo.rocketmq.extNameServer}")
public class ExtRocketMQTemplate extends RocketMQTemplate {
    //类里面不需要做任何修改
}