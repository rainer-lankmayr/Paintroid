/*
 *   This file is part of Paintroid, a software part of the Catroid project.
 *   Copyright (C) 2010  Catroid development team
 *   <http://code.google.com/p/catroid/wiki/Credits>
 *
 *   Paintroid is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU Affero General Public License as published
 *   by the Free Software Foundation, either version 3 of the License, or
 *   at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Affero General Public License for more details.
 *
 *   You should have received a copy of the GNU Affero General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package at.tugraz.ist.paintroid.command.implementation;

import java.util.LinkedList;

import at.tugraz.ist.paintroid.command.Command;
import at.tugraz.ist.paintroid.command.CommandHandler;

public class CommandHandlerImplementation implements CommandHandler {
	private final LinkedList<Command> commandQueue;

	public CommandHandlerImplementation() {
		commandQueue = new LinkedList<Command>();
	}

	@Override
	public synchronized Command getNextCommand() {
		// TODO deliver the next command from the command queue
		if (commandQueue.isEmpty()) {
			return null;
		}
		Command nextCommand = commandQueue.getFirst();
		commandQueue.removeFirst();
		return nextCommand;
	}

	@Override
	public synchronized boolean commitCommand(Command commandObject) {
		if (commandObject == null) {
			return false;
		}
		return commandQueue.add(commandObject);
	}

	@Override
	public synchronized void clearCommandQueue() {
		commandQueue.clear();
	}

}