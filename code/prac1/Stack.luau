local Stack = {}
Stack.__index = Stack

function Stack.new(size: number)
	local self = setmetatable({}, Stack)
	self.size = size
	return self
end

function Stack:push(value)
	if self:isFull() then
		print("Stack is full. Cannot push any values.")
		return
	end
	table.insert(self.array, value)
end

function Stack:pop()
	if self:isEmpty() then
		print("Stack is empty. Cannot pop any values.")
		return nil
	end
	return table.remove(self.array)
end

function Stack:peek()
	if #self.array == 0 then
		print("Stack is empty. Cannot peek any values.")
		return nil
	end
	return self.array[#self.array]
end

function Stack:isFull()
	return #self.array == self.size
end

function Stack:isEmpty()
	return #self.array == 0
end

return Stack
